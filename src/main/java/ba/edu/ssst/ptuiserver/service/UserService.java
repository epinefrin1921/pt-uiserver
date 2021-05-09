package ba.edu.ssst.ptuiserver.service;

import ba.edu.ssst.ptuiserver.model.dtos.LocationDto;
import ba.edu.ssst.ptuiserver.model.dtos.UserDto;
import ba.edu.ssst.ptuiserver.model.entities.User;
import ba.edu.ssst.ptuiserver.repositories.GenericRepository;
import ba.edu.ssst.ptuiserver.repositories.LocationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService extends GenericService<User>{

    private final LocationRepository locationRepository;
    private final ModelMapper mapper;

    @Autowired
    public UserService(GenericRepository<User> repository, LocationRepository locationRepository) {
        super(repository);
        this.mapper = new ModelMapper();
        this.locationRepository=locationRepository;
    }

    @Transactional
   public UserDto create(UserDto newDomain, Class<UserDto> dtoClass, Class<User> entityClass){
       newDomain.setLocation(locationRepository.getOne(newDomain.getLocationId()));
       newDomain = super.create(newDomain,dtoClass,entityClass);
       newDomain.setLocationDto(mapper.map(newDomain.getLocation(), LocationDto.class));
       return newDomain;
    }

    @Transactional
    public UserDto update(Long id, UserDto updated, Class<UserDto> dtoClass, Class<User> entityClass){
        get(id,dtoClass);
        updated.setLocation(locationRepository.getOne(updated.getLocationId()));
        updated = super.update(id, updated, dtoClass, entityClass);
        updated.setLocationDto(mapper.map(updated.getLocation(), LocationDto.class));
        return updated;
    }

}

