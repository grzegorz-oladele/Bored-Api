package pl.grzegorz.boredapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grzegorz.boredapi.model.entity.Activity;

/**
 * An interface that is the connection between the activity table in the database and the application.
 */

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    /**
     * The purpose of the method is to check if there is an activity in the database with the selected value "key"
     *
     * @param key activity key
     * @return true if activity with specified "key" value exists in database
     */
    boolean existsByKey(String key);
}
