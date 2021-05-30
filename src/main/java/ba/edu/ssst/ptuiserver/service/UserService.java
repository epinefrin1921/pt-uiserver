package ba.edu.ssst.ptuiserver.service;

import ba.edu.ssst.ptuiserver.exceptions.AuthException;
import ba.edu.ssst.ptuiserver.model.dtos.LocationDto;
import ba.edu.ssst.ptuiserver.model.dtos.UserDto;
import ba.edu.ssst.ptuiserver.model.entities.User;
import ba.edu.ssst.ptuiserver.repositories.GenericRepository;
import ba.edu.ssst.ptuiserver.repositories.LocationRepository;
import ba.edu.ssst.ptuiserver.repositories.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static ba.edu.ssst.ptuiserver.auth.SecurityConstants.EXPIRATION_TIME;
import static ba.edu.ssst.ptuiserver.auth.SecurityConstants.SECRET;

@Service
public class UserService extends GenericService<User> {

    private final LocationRepository locationRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final Pattern emailPattern;

    @Autowired
    public UserService(GenericRepository<User> repository, LocationRepository locationRepository,
                       UserRepository userRepository) {
        super(repository);
        this.mapper = new ModelMapper();
        this.userRepository = userRepository;
        this.locationRepository=locationRepository;
        this.emailPattern = Pattern.compile("^(.+)@(.+)$");
    }

    public List<UserDto> get(){
        List<UserDto> entities=  super.get(UserDto.class);
        entities = entities.stream().peek(this::fillForeignObjects).collect(Collectors.toList());
        return entities;
    }

    public UserDto get(Long id){
        UserDto entity = super.get(id, UserDto.class);
        this.fillForeignObjects(entity);
        return entity;
    }

    @Transactional
   public UserDto create(UserDto newDomain){
        newDomain.setPassword(BCrypt.hashpw(newDomain.getPassword(), BCrypt.gensalt(10)));
        newDomain.setEmail(newDomain.getEmail().toLowerCase(Locale.ROOT));
        this.validateEmail(newDomain.getEmail());
        this.extractDtos(newDomain);
        newDomain = super.create(newDomain, UserDto.class, User.class);
        this.fillForeignObjects(newDomain);
        return newDomain;
    }

    @Transactional
    public UserDto update(Long id, UserDto updated){
        get(id, UserDto.class);
        updated.setPassword(BCrypt.hashpw(updated.getPassword(), BCrypt.gensalt(10)));
        updated.setEmail(updated.getEmail().toLowerCase(Locale.ROOT));
        this.validateEmail(updated.getEmail());
        this.extractDtos(updated);
        updated = super.update(id, updated, UserDto.class, User.class);
        this.fillForeignObjects(updated);
        return updated;
    }

    private UserDto fillForeignObjects (UserDto jobDto){
        jobDto.setLocationDto(mapper.map(jobDto.getLocation(), LocationDto.class));
        jobDto.setLocationId(jobDto.getLocation().getId());
        return jobDto;
    }
    private UserDto extractDtos (UserDto jobDto){
        jobDto.setLocation(locationRepository.getOne(jobDto.getLocationId()));
        return jobDto;
    }

    public UserDto validateUser(String email, String password) throws AuthException {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto user = mapper.map(userRepository.findByEmail(email.toLowerCase(Locale.ROOT)), UserDto.class);
        if(!BCrypt.checkpw(password, user.getPassword())){
            throw new AuthException("Invalid email/password");
        }
        return user;
    }

    public void validateEmail(String email){
        if(!emailPattern.matcher(email).matches()){
            throw new AuthException("Invalid email format");
        }
        if(userRepository.countAllByEmail(email)>0){
            throw new AuthException("Email already in use");
        }
    }

    public Map<String, String> generateJWTToken(UserDto userDto){
        long timestamp = System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, SECRET)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + EXPIRATION_TIME))
                .claim("userId", userDto.getId())
                .claim("email", userDto.getEmail())
                .claim("firstName", userDto.getFirstName())
                .claim("lastName", userDto.getLastName())
                .compact();
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return map;
    }

}

