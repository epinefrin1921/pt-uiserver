package ba.edu.ssst.ptuiserver.controller;

import ba.edu.ssst.ptuiserver.model.dtos.GenericDto;
import ba.edu.ssst.ptuiserver.model.entities.GenericEntity;
import ba.edu.ssst.ptuiserver.repositories.GenericRepository;
import ba.edu.ssst.ptuiserver.service.GenericService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


public abstract class GenericController<T extends GenericEntity<T>,O extends GenericDto<O>> {

    private final GenericService<T> service;
    private final Class<O> dto;

    public GenericController(GenericRepository<T> repository, Class<O> userDtoClass) {
        this.service = new GenericService<T>(repository) {};
        this.dto=userDtoClass;
    }
    @GetMapping
    public ResponseEntity<Collection<O>> getAll(){
        return ResponseEntity.ok(service.get(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<O> getOne(@PathVariable Long id){
        return ResponseEntity.ok(service.get(id,dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<O> update(@RequestBody O updated,
    @PathVariable Long id){
        return ResponseEntity.ok(service.update(id,updated,dto));
    }

    @PostMapping("")
    public ResponseEntity<O> create(@RequestBody O created){
        return ResponseEntity.ok(service.create(created,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok("Ok");
    }
}
