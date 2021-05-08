package ba.edu.ssst.ptuiserver.controller;

import ba.edu.ssst.ptuiserver.model.dtos.LocationDto;
import ba.edu.ssst.ptuiserver.model.dtos.ReviewDto;
import ba.edu.ssst.ptuiserver.model.entities.Location;
import ba.edu.ssst.ptuiserver.model.entities.Review;
import ba.edu.ssst.ptuiserver.repositories.LocationRepository;
import ba.edu.ssst.ptuiserver.repositories.ReviewRepository;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
@Api(value="review", description="Operations pertaining to reviews")
public class ReviewController extends GenericController<Review, ReviewDto>{
    public ReviewController(ReviewRepository repository) {
        super(repository,ReviewDto.class, Review.class);
    }
}
