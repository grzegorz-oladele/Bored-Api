package pl.grzegorz.boredapi.mapper;

import org.springframework.stereotype.Component;
import pl.grzegorz.boredapi.builder.ActivityLogDtoInfoBuilder;
import pl.grzegorz.boredapi.model.dto.ActivityLogDtoInfo;
import pl.grzegorz.boredapi.model.entity.ActivityLog;

import java.util.Objects;

/**
 * Class used to map log objects in an application
 */

@Component
public class ActivityLogMapper {

    /**
     * Method used to repaint an object of type ActivityLog into an ActivityLogDtoInfo object,
     * which will then be passed to the frontend application.
     *
     * @param activityLog object taken directly from the database
     * @return object of type ActivityLogDtoInfo
     */

    public ActivityLogDtoInfo fromEntityToDtoInfo(ActivityLog activityLog) {
        if (activityLog == null) {
            return null;
        }
        ActivityLogDtoInfoBuilder activityLogDtoInfoBuilder = new ActivityLogDtoInfoBuilder();
        if (activityLog.getId() > 0) {
            activityLogDtoInfoBuilder.withId(activityLog.getId());
        }
        if (Objects.nonNull(activityLog.getActivityKey())) {
            activityLogDtoInfoBuilder.withActivityKey(activityLog.getActivityKey());
        }
        if (Objects.nonNull(activityLog.getCreationDate())) {
            activityLogDtoInfoBuilder.withCreationDate(activityLog.getCreationDate().toString());
        }
        return activityLogDtoInfoBuilder.build();
    }
}
