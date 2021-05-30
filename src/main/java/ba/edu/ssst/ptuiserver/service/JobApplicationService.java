package ba.edu.ssst.ptuiserver.service;

import ba.edu.ssst.ptuiserver.model.dtos.*;
import ba.edu.ssst.ptuiserver.model.entities.JobApplication;
import ba.edu.ssst.ptuiserver.repositories.GenericRepository;
import ba.edu.ssst.ptuiserver.repositories.JobRepository;
import ba.edu.ssst.ptuiserver.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobApplicationService extends GenericService<JobApplication>{
    private final JobRepository jobRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public JobApplicationService(GenericRepository<JobApplication> repository,
                                 UserRepository userRepository,
                                 JobRepository jobRepository) {
        super(repository);
        this.mapper = new ModelMapper();
        this.userRepository=userRepository;
        this.jobRepository=jobRepository;
    }

    public List<JobApplicationDto> get(){
        List<JobApplicationDto> entities = super.get(JobApplicationDto.class);
        entities = entities.stream().peek(this::fillForeignObjects).collect(Collectors.toList());
        return entities;
    }

    public JobApplicationDto get(Long id){
        JobApplicationDto entity = super.get(id, JobApplicationDto.class);
        this.fillForeignObjects(entity);
        return entity;
    }

    @Transactional
    public JobApplicationDto create(JobApplicationDto newDomain){
        this.extractDtos(newDomain);
        newDomain = super.create(newDomain, JobApplicationDto.class, JobApplication.class);
        this.fillForeignObjects(newDomain);
        return newDomain;
    }

    @Transactional
    public JobApplicationDto update(Long id, JobApplicationDto updated){
        get(id, JobApplicationDto.class);
        this.extractDtos(updated);
        updated = super.update(id, updated, JobApplicationDto.class, JobApplication.class);
        this.fillForeignObjects(updated);
        return updated;
    }

    private JobApplicationDto fillForeignObjects (JobApplicationDto jobApplicationDto){
        jobApplicationDto.setUserDto(mapper.map(jobApplicationDto.getUser(), UserDto.class));
        jobApplicationDto.setUserId(jobApplicationDto.getUser().getId());
        jobApplicationDto.setJobDto(mapper.map(jobApplicationDto.getJob(), JobDto.class));
        jobApplicationDto.setJobId(jobApplicationDto.getJob().getId());
        return jobApplicationDto;
    }
    private JobApplicationDto extractDtos (JobApplicationDto jobApplicationDto){
        jobApplicationDto.setUser(userRepository.getOne(jobApplicationDto.getUserId()));
        jobApplicationDto.setJob(jobRepository.getOne(jobApplicationDto.getJobId()));
        return jobApplicationDto;
    }

}
