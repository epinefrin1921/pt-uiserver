package ba.edu.ssst.ptuiserver.controller;

import ba.edu.ssst.ptuiserver.model.dtos.UserDto;
import ba.edu.ssst.ptuiserver.model.entities.User;
import ba.edu.ssst.ptuiserver.repositories.UserRepository;
import ba.edu.ssst.ptuiserver.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(value="users", description="Operations pertaining to users")
public class UserController extends GenericController<User,UserDto>{

    @Autowired
    private UserService userService;

    public UserController(UserRepository repository) {
        super(repository,UserDto.class, User.class);
    }

    @Override
    public ResponseEntity<UserDto> create(@RequestBody UserDto created){
        UserDto newObject = userService.create(created, UserDto.class, User.class);
        return ResponseEntity.ok(newObject);
    }
}


