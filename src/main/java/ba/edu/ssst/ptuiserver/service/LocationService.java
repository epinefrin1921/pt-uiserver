package ba.edu.ssst.ptuiserver.service;


import ba.edu.ssst.ptuiserver.model.entities.Location;
import ba.edu.ssst.ptuiserver.repositories.GenericRepository;
import org.springframework.stereotype.Service;

@Service
//@Noargsconstructor
public class LocationService extends GenericService<Location>{


    public LocationService(GenericRepository<Location> repository) {
        super(repository);
    }


   
}
