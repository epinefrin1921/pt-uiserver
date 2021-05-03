package ba.edu.ssst.ptuiserver.repositories;

import ba.edu.ssst.ptuiserver.model.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {

}
