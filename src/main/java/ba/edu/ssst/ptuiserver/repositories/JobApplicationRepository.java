package ba.edu.ssst.ptuiserver.repositories;

import ba.edu.ssst.ptuiserver.model.entities.Job;
import ba.edu.ssst.ptuiserver.model.entities.JobApplication;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface JobApplicationRepository extends GenericRepository<JobApplication>{
    Collection<JobApplication> findAllByUserId(Long userId);
    Collection<JobApplication> findAllByJobId(Long jobId);

}
