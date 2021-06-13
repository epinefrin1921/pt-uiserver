package ba.edu.ssst.ptuiserver.repositories;

import ba.edu.ssst.ptuiserver.model.entities.Job;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface JobRepository extends GenericRepository<Job>{
    Collection<Job> findAllByOwnerId(Long userId);
}
