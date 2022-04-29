package pl.grzegorz.boredapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pl.grzegorz.boredapi.model.entity.BoredEntity;

@Service
public interface BoredRepository extends JpaRepository<BoredEntity, Long> {
}
