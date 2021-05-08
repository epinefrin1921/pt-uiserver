package ba.edu.ssst.ptuiserver.service;


import ba.edu.ssst.ptuiserver.model.dtos.UserDto;
import ba.edu.ssst.ptuiserver.model.entities.User;
import ba.edu.ssst.ptuiserver.repositories.GenericRepository;
import ba.edu.ssst.ptuiserver.repositories.LocationRepository;
import ba.edu.ssst.ptuiserver.repositories.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService extends GenericService<User>{

   ` private final LocationRepository locationRepository = new LocationRepository() {
    };

    public UserService(GenericRepository<User> repository) {
        super(repository);
    }



   public UserDto create(UserDto newDomain, Class<UserDto> dtoClass, Class<User> entityClass){
       newDomain.setLocation();
       return super.create(newDomain,dtoClass,entityClass);
    }
}

