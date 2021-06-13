package ba.edu.ssst.ptuiserver.service;

import ba.edu.ssst.ptuiserver.model.dtos.*;
import ba.edu.ssst.ptuiserver.model.entities.Job;
import ba.edu.ssst.ptuiserver.model.entities.JobApplication;
import ba.edu.ssst.ptuiserver.repositories.GenericRepository;
import ba.edu.ssst.ptuiserver.repositories.JobApplicationRepository;
import ba.edu.ssst.ptuiserver.repositories.JobRepository;
import ba.edu.ssst.ptuiserver.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobApplicationService extends GenericService<JobApplication>{
    private final JobRepository jobRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final JobApplicationRepository jobApplicationRepository;

    public JobApplicationService(GenericRepository<JobApplication> repository,
                                 UserRepository userRepository,
                                 JobApplicationRepository jobApplicationRepository,
                                 JobRepository jobRepository) {
        super(repository);
        this.mapper = new ModelMapper();
        this.userRepository=userRepository;
        this.jobRepository=jobRepository;
        this.jobApplicationRepository=jobApplicationRepository;
    }

    public List<JobApplicationDto> get(){
        List<JobApplicationDto> entities = super.get(JobApplicationDto.class);
        entities = entities.stream().peek(this::fillForeignObjects).collect(Collectors.toList());
        return entities;
    }

    public List<JobApplicationDto> getUsersApplications(String userId){
        Collection<JobApplication> entities=jobApplicationRepository.findAllByUserId(Long.parseLong(userId));
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<JobApplicationDto> dtos = entities.stream().map(jobApplication -> mapper.map(jobApplication, JobApplicationDto.class)).collect(Collectors.toList());
        return dtos.stream().peek(this::fillForeignObjects).collect(Collectors.toList());
    }

    public List<JobApplicationDto> getJobApplications(String jobId){
        Collection<JobApplication> entities=jobApplicationRepository.findAllByJobId(Long.parseLong(jobId));
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<JobApplicationDto> dtos = entities.stream().map(jobApplication -> mapper.map(jobApplication, JobApplicationDto.class)).collect(Collectors.toList());
        return dtos.stream().peek(this::fillForeignObjects).collect(Collectors.toList());
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
