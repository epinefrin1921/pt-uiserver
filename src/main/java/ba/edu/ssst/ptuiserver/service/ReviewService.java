package ba.edu.ssst.ptuiserver.service;


import ba.edu.ssst.ptuiserver.model.entities.Review;
import ba.edu.ssst.ptuiserver.repositories.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService extends GenericService<Review>{
    public ReviewService(GenericRepository<Review> repository) {
        super(repository);
    }
}
