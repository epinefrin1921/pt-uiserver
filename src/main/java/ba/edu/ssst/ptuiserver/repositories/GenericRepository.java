package ba.edu.ssst.ptuiserver.repositories;

import ba.edu.ssst.ptuiserver.model.entities.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T extends GenericEntity> extends JpaRepository<T, Long> {
}
