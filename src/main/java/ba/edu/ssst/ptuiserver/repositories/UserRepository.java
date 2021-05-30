package ba.edu.ssst.ptuiserver.repositories;

import ba.edu.ssst.ptuiserver.model.entities.User;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends GenericRepository<User> {
    User findByEmail(String email);
    Integer countAllByEmail(String email);
}
