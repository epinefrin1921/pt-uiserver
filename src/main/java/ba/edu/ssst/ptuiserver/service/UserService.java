package ba.edu.ssst.ptuiserver.service;


import ba.edu.ssst.ptuiserver.model.entities.User;
import ba.edu.ssst.ptuiserver.repositories.GenericRepository;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class UserService extends GenericService<User>{


    public UserService(GenericRepository<User> repository) {
        super(repository);
    }


}

