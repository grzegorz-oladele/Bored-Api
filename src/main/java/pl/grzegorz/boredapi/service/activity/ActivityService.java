package pl.grzegorz.boredapi.service.activity;

import pl.grzegorz.boredapi.model.dto.ActivityDtoInfo;

/**
 * A markup interface for a service that handles communication with a database activity table
 */

public interface ActivityService {

    /**
     * A method to add a new activity to the database.
     * @return remapped object of type ActivityDtoInfo
     */
    ActivityDtoInfo addActivity();
}
