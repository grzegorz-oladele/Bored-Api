package pl.grzegorz.boredapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grzegorz.boredapi.model.entity.ActivityLog;

@Repository
public interface LogRepository extends JpaRepository<ActivityLog, Long> {
}
