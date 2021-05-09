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
    private final Class<O> dtoType;
    private final Class<T> entityType;

    public GenericController(GenericRepository<T> repository, Class<O> dtoType, Class<T> entityType) {
        this.service = new GenericService<T>(repository) {};
        this.dtoType =dtoType;
        this.entityType = entityType;
    }
    @GetMapping
    public ResponseEntity<Collection<O>> getAll(){
        return ResponseEntity.ok(service.get(dtoType));
    }

    @GetMapping("/{id}")
    public ResponseEntity<O> getOne(@PathVariable Long id){
        return ResponseEntity.ok(service.get(id, dtoType));
    }

    @PutMapping("/{id}")
    public ResponseEntity<O> update(@RequestBody O updated,
    @PathVariable Long id){
        return ResponseEntity.ok(service.update(id,updated, dtoType, entityType));
    }

    @PostMapping("")
    public ResponseEntity<O> create(@RequestBody O created){
        return ResponseEntity.ok(service.create(created, dtoType, entityType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.delete(id, entityType);
        return ResponseEntity.ok("Ok");
    }
}
