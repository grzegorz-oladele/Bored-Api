package pl.grzegorz.boredapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grzegorz.boredapi.model.entity.ActivityLog;

/**
 * An interface that is the connection between the activity log table in the database and the application.
 */

@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
}
