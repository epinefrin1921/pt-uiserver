package ba.edu.ssst.ptuiserver.service;

import ba.edu.ssst.ptuiserver.model.entities.GenericEntity;
import ba.edu.ssst.ptuiserver.repositories.GenericRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;



import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public abstract class GenericService<T extends GenericEntity<T>> {

    private final GenericRepository<T> repository;

    private final Class<T> entityClass;
    private final ModelMapper mapper;


    protected GenericService(GenericRepository<T> repository) {
        this.mapper= new ModelMapper();
        this.repository = repository;
        entityClass = getEntityClass();
    }
    @SuppressWarnings("unchecked")
    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }
    public <O> List<O> get(Class<O> dtoClass){
        Collection<T> entities=repository.findAll();
        Stream<O> dtos=entities.stream().map(e->insert(e,dtoClass));
        return dtos.collect(Collectors.toList());
    }

    public <O> O get(Long id, Class<O> dtoClass){
        return  insert(repository.findById(id).orElseThrow(
                () ->new ResponseStatusException(NOT_FOUND, "Unable to find resource")
        ),dtoClass);
    }

    @Transactional
    public <O> O update(Long id,O updated, Class<O> dtoClass){
        get(id,dtoClass);
        T entity=insert(updated,this.entityClass);
        entity.setId(id);
        entity = repository.save(entity);
        return insert(entity,dtoClass);
    }

    @Transactional
    public <O> O create(O newDomain,Class<O> dtoClass){
        T newEntity= insert(newDomain,this.entityClass);
        newEntity=repository.save(newEntity);
        return insert(newEntity,dtoClass);
    }

    @Transactional
    public void delete(Long id){
        //check if object with this id exists
        get(id,this.entityClass);
        repository.deleteById(id);
    }

    public <I, O> O insert(I inputData, Class<O> outClass) {
        T entity = mapper.map(inputData, entityClass);
        return mapper.map(entity, outClass);
    }
}
