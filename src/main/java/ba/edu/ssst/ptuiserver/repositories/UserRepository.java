package ba.edu.ssst.ptuiserver.repositories;

import ba.edu.ssst.ptuiserver.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
