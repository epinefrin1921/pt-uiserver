package ba.edu.ssst.ptuiserver.repositories;

import ba.edu.ssst.ptuiserver.model.entities.Message;
import org.springframework.stereotype.Component;

@Component
public interface MessageRepository extends GenericRepository<Message>{
}
