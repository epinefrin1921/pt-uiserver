package ba.edu.ssst.ptuiserver.service;

import ba.edu.ssst.ptuiserver.model.dtos.LocationDto;
import ba.edu.ssst.ptuiserver.model.entities.Location;
import ba.edu.ssst.ptuiserver.repositories.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationService {
    
    private final LocationRepository locationRepository;

    public Collection<LocationDto> getList() {
        // todo: proper filtering
        return locationRepository.findAll().stream()
                .map(this::toPayload)
                .collect(Collectors.toList());
    }

    public LocationDto get(Long id) {
        Optional<Location> LocationOptional = locationRepository.findById(id);
        if (LocationOptional.isPresent()) {
            return toPayload(LocationOptional.get());
        }
        throw new RuntimeException("Location with id:" + id + " doesn't exist!");
    }

    public LocationDto save(LocationDto payload) {
        Location Location = fromPayload(payload);
        Location = locationRepository.save(Location);
        return toPayload(Location);
    }

    public LocationDto update(Long id, LocationDto payload) {
        get(id);

        Location Location = fromPayload(payload);
        Location.setId(id);
        Location = locationRepository.save(Location);
        return toPayload(Location);
    }

    public void delete(Long id) {
        locationRepository.deleteById(id);
    }

    private Location fromPayload(LocationDto payload) {
        Location location = new Location();
        location.setArea(payload.getArea());
        location.setCity(payload.getCity());
        return location;
    }

    private LocationDto toPayload(Location location) {
        LocationDto payload = new LocationDto();
        payload.setArea(location.getArea());
        payload.setCity(location.getCity());
        return payload;
    }
   
}
