package ba.edu.ssst.ptuiserver.controller;

import ba.edu.ssst.ptuiserver.model.dtos.ApplicationDto;
import ba.edu.ssst.ptuiserver.model.entities.Application;
import ba.edu.ssst.ptuiserver.repositories.GenericRepository;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
@Api(value="applications")
public class ApplicationController extends GenericController<Application, ApplicationDto> {
    public ApplicationController(GenericRepository<Application> repository) {
        super(repository, ApplicationDto.class, Application.class);
    }
}
