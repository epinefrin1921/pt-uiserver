package ba.edu.ssst.ptuiserver.service;

import ba.edu.ssst.ptuiserver.model.entities.Application;
import ba.edu.ssst.ptuiserver.repositories.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService extends GenericService<Application>{

    public ApplicationService(GenericRepository<Application> repository) {
        super(repository);
    }
}
