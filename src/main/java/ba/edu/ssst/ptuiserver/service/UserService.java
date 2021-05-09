package ba.edu.ssst.ptuiserver.service;

import ba.edu.ssst.ptuiserver.model.dtos.LocationDto;
import ba.edu.ssst.ptuiserver.model.dtos.UserDto;
import ba.edu.ssst.ptuiserver.model.entities.Location;
import ba.edu.ssst.ptuiserver.model.entities.User;
import ba.edu.ssst.ptuiserver.repositories.GenericRepository;
import ba.edu.ssst.ptuiserver.repositories.LocationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

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
       Location newLocation = locationRepository.getOne(newDomain.getLocationId());
       newDomain.setLocation(newLocation);
       newDomain = super.create(newDomain,dtoClass,entityClass);
       newDomain.setLocationDto(mapper.map( newDomain.getLocation(), LocationDto.class));
       newDomain.setLocation(null);
       return newDomain;
    }
}

