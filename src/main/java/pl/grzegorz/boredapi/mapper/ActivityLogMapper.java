package pl.grzegorz.boredapi.mapper;

import org.springframework.stereotype.Component;
import pl.grzegorz.boredapi.builder.ActivityLogDtoInfoBuilder;
import pl.grzegorz.boredapi.model.dto.ActivityLogDtoInfo;
import pl.grzegorz.boredapi.model.entity.ActivityLog;

import java.util.Objects;

@Component
public class ActivityLogMapper {

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
