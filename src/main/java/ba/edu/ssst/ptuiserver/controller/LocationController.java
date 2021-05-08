package ba.edu.ssst.ptuiserver.controller;

import ba.edu.ssst.ptuiserver.model.dtos.LocationDto;
import ba.edu.ssst.ptuiserver.model.entities.Location;
import ba.edu.ssst.ptuiserver.repositories.LocationRepository;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/location")
@Api(value="locations", description="Operations pertaining to locations")
public class LocationController extends GenericController<Location,LocationDto>{

    public LocationController(LocationRepository repository) {
        super(repository,LocationDto.class, Location.class);
    }
}
