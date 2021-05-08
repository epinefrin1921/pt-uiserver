package ba.edu.ssst.ptuiserver.service;

import ba.edu.ssst.ptuiserver.model.entities.Category;
import ba.edu.ssst.ptuiserver.repositories.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends GenericService<Category>{
    public CategoryService(GenericRepository<Category> repository) {
        super(repository);
    }
}
