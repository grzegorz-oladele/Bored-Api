package pl.grzegorz.boredapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grzegorz.boredapi.model.entity.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    boolean existsByKey(String key);
}
