package ba.edu.ssst.ptuiserver.controller;


import ba.edu.ssst.ptuiserver.model.dtos.UserDto;
import ba.edu.ssst.ptuiserver.model.entities.User;
import ba.edu.ssst.ptuiserver.repositories.GenericRepository;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user")
@Api(value="users", description="Operations pertaining to users")
public class UserController extends GenericController<User,UserDto>{

    public UserController(GenericRepository<User> repository) {
        super(repository,UserDto.class);
    }
}


