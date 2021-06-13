package ba.edu.ssst.ptuiserver.service;

import ba.edu.ssst.ptuiserver.model.dtos.CategoryDto;
import ba.edu.ssst.ptuiserver.model.dtos.JobDto;
import ba.edu.ssst.ptuiserver.model.dtos.LocationDto;
import ba.edu.ssst.ptuiserver.model.dtos.UserDto;
import ba.edu.ssst.ptuiserver.model.entities.Job;
import ba.edu.ssst.ptuiserver.repositories.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class JobService extends GenericService<Job>{

    private final LocationRepository locationRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;
    private final ModelMapper mapper;

    @Autowired
    public JobService(GenericRepository<Job> repository,
                      LocationRepository locationRepository,
                      CategoryRepository categoryRepository,
                      UserRepository userRepository,
                      JobRepository jobRepository) {
        super(repository);
        this.mapper = new ModelMapper();
        this.locationRepository=locationRepository;
        this.categoryRepository=categoryRepository;
        this.userRepository=userRepository;
        this.jobRepository=jobRepository;
    }

    public List<JobDto> get(){
        List<JobDto> entities = super.get(JobDto.class);
        entities = entities.stream().peek(this::fillForeignObjects).collect(Collectors.toList());
        return entities;
    }

    public List<JobDto> getUsersJob(String userId){
        Collection<Job> entities=jobRepository.findAllByOwnerId(Long.parseLong(userId));
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<JobDto> dtos = entities.stream().map(job -> mapper.map(job, JobDto.class)).collect(Collectors.toList());
        return dtos.stream().peek(this::fillForeignObjects).collect(Collectors.toList());
    }

    public JobDto get(Long id){
        JobDto entity = super.get(id, JobDto.class);
        this.fillForeignObjects(entity);
        return entity;
    }

    @Transactional
    public JobDto create(JobDto newDomain){
        this.extractDtos(newDomain);
        newDomain = super.create(newDomain, JobDto.class, Job.class);
        this.fillForeignObjects(newDomain);
        return newDomain;
    }

    @Transactional
    public JobDto update(Long id, JobDto updated){
        get(id, JobDto.class);
        this.extractDtos(updated);
        updated = super.update(id, updated, JobDto.class, Job.class);
        this.fillForeignObjects(updated);
        return updated;
    }

    private JobDto fillForeignObjects (JobDto jobDto){
        jobDto.setLocationDto(mapper.map(jobDto.getLocation(), LocationDto.class));
        jobDto.setLocationId(jobDto.getLocation().getId());
        jobDto.setOwnerDto(mapper.map(jobDto.getOwner(), UserDto.class));
        jobDto.setOwnerId(jobDto.getOwner().getId());
        jobDto.setCategoryDto(mapper.map(jobDto.getCategory(), CategoryDto.class));
        jobDto.setCategoryId(jobDto.getCategory().getId());
        return jobDto;
    }
    private JobDto extractDtos (JobDto jobDto){
        jobDto.setLocation(locationRepository.getOne(jobDto.getLocationId()));
        jobDto.setOwner(userRepository.getOne(jobDto.getOwnerId()));
        jobDto.setCategory(categoryRepository.getOne(jobDto.getCategoryId()));
        return jobDto;
    }
}
