package ba.edu.ssst.ptuiserver.service;

import ba.edu.ssst.ptuiserver.model.entities.Job;
import ba.edu.ssst.ptuiserver.repositories.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class JobService extends GenericService<Job>{

    public JobService(GenericRepository<Job> repository) {
        super(repository);
    }
}
