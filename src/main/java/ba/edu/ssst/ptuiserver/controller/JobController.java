package ba.edu.ssst.ptuiserver.controller;

import ba.edu.ssst.ptuiserver.model.dtos.JobDto;
import ba.edu.ssst.ptuiserver.model.entities.Job;
import ba.edu.ssst.ptuiserver.repositories.JobRepository;
import ba.edu.ssst.ptuiserver.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/job")
public class JobController extends GenericController<Job, JobDto>{
    @Autowired
    private JobService jobService;

    public JobController(JobRepository repository) {
        super(repository,JobDto.class, Job.class);
    }

    @Override
    @GetMapping
    public ResponseEntity<Collection<JobDto>> getAll(){
        return ResponseEntity.ok(jobService.get());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Collection<JobDto>> getAllByUser(@PathVariable String id){
        if(id != null){
            return ResponseEntity.ok(jobService.getUsersJob(id));
        }
        return ResponseEntity.ok(jobService.get());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<JobDto> getOne(@PathVariable Long id){
        return ResponseEntity.ok(jobService.get(id));
    }

    @Override
    @PostMapping("")
    public ResponseEntity<JobDto> create(@RequestBody JobDto created){
        JobDto newObject = jobService.create(created);
        return ResponseEntity.ok(newObject);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<JobDto> update(@RequestBody JobDto created, @PathVariable Long id){
        JobDto newObject = jobService.update(id, created);
        return ResponseEntity.ok(newObject);
    }
}
