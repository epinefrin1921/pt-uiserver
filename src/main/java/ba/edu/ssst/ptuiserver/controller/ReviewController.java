package ba.edu.ssst.ptuiserver.controller;

import ba.edu.ssst.ptuiserver.model.dtos.ReviewDto;
import ba.edu.ssst.ptuiserver.model.entities.Review;
import ba.edu.ssst.ptuiserver.repositories.ReviewRepository;
import ba.edu.ssst.ptuiserver.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/review")
public class ReviewController extends GenericController<Review, ReviewDto>{

    @Autowired
    private ReviewService reviewService;

    public ReviewController(ReviewRepository repository) {
        super(repository,ReviewDto.class, Review.class);
    }
    @Override
    @GetMapping
    public ResponseEntity<Collection<ReviewDto>> getAll(){
        return ResponseEntity.ok(reviewService.get());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> getOne(@PathVariable Long id){
        return ResponseEntity.ok(reviewService.get(id));
    }

    @Override
    @PostMapping("")
    public ResponseEntity<ReviewDto> create(@RequestBody ReviewDto created){
        ReviewDto newObject = reviewService.create(created);
        return ResponseEntity.ok(newObject);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ReviewDto> update(@RequestBody ReviewDto created, @PathVariable Long id){
        ReviewDto newObject = reviewService.update(id, created);
        return ResponseEntity.ok(newObject);
    }
}
