package ba.edu.ssst.ptuiserver.model.entities;

public interface GenericEntity<T> {
    void update(T source);
    Long getId();
    void setId(Long id);
    T createNewInstance();
}
