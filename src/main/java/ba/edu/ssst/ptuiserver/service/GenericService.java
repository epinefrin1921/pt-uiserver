package ba.edu.ssst.ptuiserver.service;

import ba.edu.ssst.ptuiserver.model.entities.GenericEntity;
import ba.edu.ssst.ptuiserver.repositories.GenericRepository;
import org.modelmapper.ModelMapper;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public abstract class GenericService<T extends GenericEntity<T>> {

    private final GenericRepository<T> repository;

//    private final Class<T> entityClass;
    private final ModelMapper mapper;

    public GenericService(GenericRepository<T> repository) {
        this.mapper= new ModelMapper();
        this.repository = repository;
    }

    public <O> List<O> get(Class<O> dtoClass){
        Collection<T> entities=repository.findAll();
        Stream<O> dtos=entities.stream().map(e->toPayload(e,dtoClass));
        return dtos.collect(Collectors.toList());
    }

    public <O> O get(Long id, Class<O> dtoClass){
        return  toPayload(repository.findById(id).orElseThrow(
                () ->new ResponseStatusException(NOT_FOUND, "Unable to find resource")
        ),dtoClass);
    }

    @Transactional
    public <O> O update(Long id,O updated, Class<O> dtoClass, Class<T> entityClass){
        get(id,dtoClass);
        T entity=fromPayload(updated,entityClass);
        entity.setId(id);
        entity = repository.save(entity);
        return toPayload(entity,dtoClass);
    }

    @Transactional
    public <O> O create(O newDomain,Class<O> dtoClass, Class<T> entityClass){
        T newEntity= fromPayload(newDomain, entityClass);
        newEntity=repository.save(newEntity);
        return toPayload(newEntity,dtoClass);
    }

    @Transactional
    public void delete(Long id, Class<T> entityClass){
        //check if object with this id exists
        get(id,entityClass);
        repository.deleteById(id);
    }

    public <O> T fromPayload(O inputData, Class<T> outputClass) {
        return mapper.map(inputData, outputClass);
    }
    public <O> O toPayload(T inputData, Class<O> outputClass) {
        return mapper.map(inputData, outputClass);
    }
}
