package ba.edu.ssst.ptuiserver.controller;

import ba.edu.ssst.ptuiserver.model.dtos.JobApplicationDto;
import ba.edu.ssst.ptuiserver.model.dtos.JobDto;
import ba.edu.ssst.ptuiserver.model.entities.JobApplication;
import ba.edu.ssst.ptuiserver.repositories.GenericRepository;
import ba.edu.ssst.ptuiserver.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/application")
public class JobApplicationController extends GenericController<JobApplication, JobApplicationDto> {

    @Autowired
    private JobApplicationService jobApplicationService;

    public JobApplicationController(GenericRepository<JobApplication> repository) {
        super(repository, JobApplicationDto.class, JobApplication.class);
    }

    @Override
    @GetMapping
    public ResponseEntity<Collection<JobApplicationDto>> getAll(){
        return ResponseEntity.ok(jobApplicationService.get());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Collection<JobApplicationDto>> getAllByUser(@PathVariable String id){
        if(id != null){
            return ResponseEntity.ok(jobApplicationService.getUsersApplications(id));
        }
        return ResponseEntity.ok(jobApplicationService.get());
    }

    @GetMapping("/job/{id}")
    public ResponseEntity<Collection<JobApplicationDto>> getAllByJob(@PathVariable String id){
        if(id != null){
            return ResponseEntity.ok(jobApplicationService.getJobApplications(id));
        }
        return ResponseEntity.ok(jobApplicationService.get());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<JobApplicationDto> getOne(@PathVariable Long id){
        return ResponseEntity.ok(jobApplicationService.get(id));
    }

    @Override
    @PostMapping("")
    public ResponseEntity<JobApplicationDto> create(@RequestBody JobApplicationDto created){
        JobApplicationDto newObject = jobApplicationService.create(created);
        return ResponseEntity.ok(newObject);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<JobApplicationDto> update(@RequestBody JobApplicationDto created, @PathVariable Long id){
        JobApplicationDto newObject = jobApplicationService.update(id, created);
        return ResponseEntity.ok(newObject);
    }

}
