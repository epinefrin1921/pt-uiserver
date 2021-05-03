package ba.edu.ssst.ptuiserver.controller;

import ba.edu.ssst.ptuiserver.model.dtos.UserDto;
import ba.edu.ssst.ptuiserver.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/user")
@Api(value="users", description="Operations pertaining to users")
public class UserController {
    
        UserService service;

        public UserController(final UserService service) {
            this.service = service;
        }

        @GetMapping
        public ResponseEntity<Collection<UserDto>> list(
        ) {
            Collection<UserDto> Users = service.getList();
            return ResponseEntity.status(HttpStatus.OK).body(Users);
        }

        @GetMapping("/{id}")
        public ResponseEntity<UserDto> get(
                @PathVariable Long id
        ) {
            UserDto User = service.get(id);

            return ResponseEntity.status(HttpStatus.OK).body(User);
        }

        @PostMapping
        public ResponseEntity<UserDto> save(
                @RequestBody UserDto User
        ) {
            UserDto result = service.save(User);

            return ResponseEntity.status(HttpStatus.OK).body(result);
        }

        @PutMapping("/{id}")
        public ResponseEntity<UserDto> update(
                @PathVariable Long id,
                @RequestBody UserDto User
        ) {
            UserDto result = service.update(id, User);

            return ResponseEntity.status(HttpStatus.OK).body(result);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<UserDto> update(
                @PathVariable Long id
        ) {
            service.delete(id);

            return ResponseEntity.noContent().build();
        }
    }


