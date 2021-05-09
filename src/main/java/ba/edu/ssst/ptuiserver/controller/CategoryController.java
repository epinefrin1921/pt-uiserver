package ba.edu.ssst.ptuiserver.controller;

import ba.edu.ssst.ptuiserver.model.dtos.CategoryDto;
import ba.edu.ssst.ptuiserver.model.entities.Category;
import ba.edu.ssst.ptuiserver.repositories.CategoryRepository;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@Api(value="categories")
public class CategoryController extends GenericController<Category, CategoryDto>{

    public CategoryController(CategoryRepository repository) {
        super(repository,CategoryDto.class, Category.class);
    }
}
