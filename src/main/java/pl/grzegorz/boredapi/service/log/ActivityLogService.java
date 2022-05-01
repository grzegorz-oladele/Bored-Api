package pl.grzegorz.boredapi.service.log;

import pl.grzegorz.boredapi.model.dto.ActivityLogDtoInfo;
import pl.grzegorz.boredapi.model.entity.ActivityLog;

import java.util.List;

/**
 * A markup interface for a service that handles communication with a database log table
 */

public interface ActivityLogService {

    /**
     * method for adding a log to the database
     *
     * @param log object containing information about the activity code and the date and time when the log was
     *            added to the database
     */
    void addLog(ActivityLog log);

    /**
     * Method to display all database logs
     *
     * @return a list of logs mapped to a list of ActivityLogDtoInfo type objects
     */
    List<ActivityLogDtoInfo> getAllLogs();
}
