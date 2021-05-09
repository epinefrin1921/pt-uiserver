package ba.edu.ssst.ptuiserver.controller;

import ba.edu.ssst.ptuiserver.model.dtos.UserDto;
import ba.edu.ssst.ptuiserver.model.entities.User;
import ba.edu.ssst.ptuiserver.repositories.UserRepository;
import ba.edu.ssst.ptuiserver.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(value="users")
public class UserController extends GenericController<User,UserDto>{

    @Autowired
    private UserService userService;

    public UserController(UserRepository repository) {
        super(repository,UserDto.class, User.class);
    }

    @Override
    @PostMapping("")
    public ResponseEntity<UserDto> create(@RequestBody UserDto created){
        UserDto newObject = userService.create(created, UserDto.class, User.class);
        return ResponseEntity.ok(newObject);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@RequestBody UserDto created, @PathVariable Long id){
        UserDto newObject = userService.update(id, created, UserDto.class, User.class);
        return ResponseEntity.ok(newObject);
    }
}


