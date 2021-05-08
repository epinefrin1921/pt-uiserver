package ba.edu.ssst.ptuiserver.controller;


import ba.edu.ssst.ptuiserver.model.dtos.UserDto;
import ba.edu.ssst.ptuiserver.model.entities.User;
import ba.edu.ssst.ptuiserver.repositories.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
@Api(value="users", description="Operations pertaining to users")
public class UserController extends GenericController<User,UserDto>{

    public UserController(UserRepository repository) {
        super(repository,UserDto.class, User.class);
    }
}


