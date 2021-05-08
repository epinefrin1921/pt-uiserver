package ba.edu.ssst.ptuiserver.model.entities;




public interface GenericEntity<T> {

    // update current instance with provided data
    void update(T source);

    Long getId();

    void setId(Long id);

    // based on current data create new instance with new id
    T createNewInstance();

}
