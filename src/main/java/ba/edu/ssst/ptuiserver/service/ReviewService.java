package ba.edu.ssst.ptuiserver.service;

import ba.edu.ssst.ptuiserver.model.dtos.*;
import ba.edu.ssst.ptuiserver.model.entities.Review;
import ba.edu.ssst.ptuiserver.repositories.GenericRepository;
import ba.edu.ssst.ptuiserver.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService extends GenericService<Review>{

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public ReviewService(GenericRepository<Review> repository,
                         UserRepository userRepository) {
        super(repository);
        this.mapper = new ModelMapper();
        this.userRepository=userRepository;
    }
    public List<ReviewDto> get(){
        List<ReviewDto> entities = super.get(ReviewDto.class);
        entities = entities.stream().peek(this::fillForeignObjects).collect(Collectors.toList());
        return entities;
    }

    public ReviewDto get(Long id){
        ReviewDto entity = super.get(id, ReviewDto.class);
        this.fillForeignObjects(entity);
        return entity;
    }

    @Transactional
    public ReviewDto create(ReviewDto newDomain){
        this.extractDtos(newDomain);
        newDomain = super.create(newDomain, ReviewDto.class, Review.class);
        this.fillForeignObjects(newDomain);
        return newDomain;
    }

    @Transactional
    public ReviewDto update(Long id, ReviewDto updated){
        get(id, ReviewDto.class);
        this.extractDtos(updated);
        updated = super.update(id, updated, ReviewDto.class, Review.class);
        this.fillForeignObjects(updated);
        return updated;
    }

    private ReviewDto fillForeignObjects (ReviewDto reviewDto){
        reviewDto.setPostedByDto(mapper.map(reviewDto.getPostedBy(), UserDto.class));
        reviewDto.setPostedById(reviewDto.getPostedBy().getId());
        reviewDto.setUserDto(mapper.map(reviewDto.getUser(), UserDto.class));
        reviewDto.setUserId(reviewDto.getUser().getId());
        return reviewDto;
    }
    private ReviewDto extractDtos (ReviewDto reviewDto){
        reviewDto.setPostedBy(userRepository.getOne(reviewDto.getUserId()));
        reviewDto.setUser(userRepository.getOne(reviewDto.getPostedById()));
        return reviewDto;
    }
}
