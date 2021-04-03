package ba.edu.ssst.ptuiserver.controller;

import ba.edu.ssst.ptuiserver.model.Accountant;
import ba.edu.ssst.ptuiserver.service.AccountantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accountant")
public class AccountController {
    AccountantService service;

    public AccountController(final  AccountantService service){
        this.service=service;
    }

    @GetMapping
    public ResponseEntity<List<Accountant>> getList(
//            @RequestParam(required = false, defaultValue = "Ajdin") String lastName,
//            @RequestParam(required = false, defaultValue = "Nedim") String firstName
    ){
        List<Accountant> accountants = service.get();
        return ResponseEntity.status(HttpStatus.OK).body(accountants);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Accountant> getOne(
            @PathVariable Long id
    ){
        Accountant accountant = service.get(id);
        return  ResponseEntity.status(HttpStatus.OK).body(accountant);
    }

    @PostMapping
    public ResponseEntity<Accountant> addOne(
            @RequestBody Accountant accountant
    ){
        service.save(accountant);
        return ResponseEntity.status(HttpStatus.OK).body(accountant);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Accountant> update(
            @PathVariable Long id,
            @RequestBody Accountant accountant
    ){
        service.update(id,accountant);
        return ResponseEntity.status(HttpStatus.OK).body(accountant);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id
    ){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Account deleted");
    }
}
