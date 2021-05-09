package ba.edu.ssst.ptuiserver.service;

import ba.edu.ssst.ptuiserver.model.entities.Message;
import ba.edu.ssst.ptuiserver.repositories.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService extends GenericService<Message>{

    public MessageService(GenericRepository<Message> repository) {
        super(repository);
    }
}
