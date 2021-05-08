package ba.edu.ssst.ptuiserver.controller;

import ba.edu.ssst.ptuiserver.model.dtos.GenericDto;
import ba.edu.ssst.ptuiserver.model.dtos.LocationDto;
import ba.edu.ssst.ptuiserver.model.entities.Location;
import ba.edu.ssst.ptuiserver.repositories.GenericRepository;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/location")
@Api(value="locations", description="Operations pertaining to locations")
public class LocationController extends GenericController<Location,LocationDto>{




    public LocationController(GenericRepository<Location> repository) {
        super(repository,LocationDto.class);
    }
}

`
