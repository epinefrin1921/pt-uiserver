package ba.edu.ssst.ptuiserver.controller;

import ba.edu.ssst.ptuiserver.model.dtos.UserDto;
import ba.edu.ssst.ptuiserver.model.entities.User;
import ba.edu.ssst.ptuiserver.repositories.UserRepository;
import ba.edu.ssst.ptuiserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController extends GenericController<User,UserDto>{

    @Autowired
    private UserService userService;

    public UserController(UserRepository repository) {
        super(repository,UserDto.class, User.class);
    }
    @Override
    @GetMapping("/data")
    public ResponseEntity<Collection<UserDto>> getAll(){
        return ResponseEntity.ok(userService.get());
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, Object> userMap){
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        UserDto user = userService.validateUser(email, password);
        return ResponseEntity.ok(userService.generateJWTToken(user));
    }

    @Override
    @GetMapping("/data/{id}")
    public ResponseEntity<UserDto> getOne(@PathVariable Long id){
        return ResponseEntity.ok(userService.get(id));
    }

    @Override
    @PostMapping("/data")
    public ResponseEntity<UserDto> create(@RequestBody UserDto created){
        UserDto newObject = userService.create(created);
        return ResponseEntity.ok(newObject);
    }

    @Override
    @PutMapping("/data/{id}")
    public ResponseEntity<UserDto> update(@RequestBody UserDto created, @PathVariable Long id){
        UserDto newObject = userService.update(id, created);
        return ResponseEntity.ok(newObject);
    }
}


