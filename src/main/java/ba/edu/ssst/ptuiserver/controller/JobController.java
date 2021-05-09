package ba.edu.ssst.ptuiserver.controller;

import ba.edu.ssst.ptuiserver.model.dtos.JobDto;
import ba.edu.ssst.ptuiserver.model.entities.Job;
import ba.edu.ssst.ptuiserver.repositories.JobRepository;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
@Api(value="jobs", description="Operations pertaining to jobs")
public class JobController extends GenericController<Job, JobDto>{
    public JobController(JobRepository repository) {
        super(repository,JobDto.class, Job.class);
    }
}
