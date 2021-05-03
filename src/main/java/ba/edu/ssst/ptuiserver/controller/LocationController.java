package ba.edu.ssst.ptuiserver.controller;

import ba.edu.ssst.ptuiserver.model.dtos.LocationDto;
import ba.edu.ssst.ptuiserver.service.LocationService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/location")
@Api(value="locations", description="Operations pertaining to locations")
public class LocationController {

    LocationService service;

    public LocationController(final LocationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Collection<LocationDto>> list(
    ) {
        Collection<LocationDto> Locations = service.getList();
        return ResponseEntity.status(HttpStatus.OK).body(Locations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationDto> get(
            @PathVariable Long id
    ) {
        LocationDto Location = service.get(id);

        return ResponseEntity.status(HttpStatus.OK).body(Location);
    }

    @PostMapping
    public ResponseEntity<LocationDto> save(
            @RequestBody LocationDto Location
    ) {
        LocationDto result = service.save(Location);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationDto> update(
            @PathVariable Long id,
            @RequestBody LocationDto Location
    ) {
        LocationDto result = service.update(id, Location);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LocationDto> update(
            @PathVariable Long id
    ) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}

