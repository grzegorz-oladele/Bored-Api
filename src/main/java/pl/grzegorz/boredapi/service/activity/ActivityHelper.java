package pl.grzegorz.boredapi.service.activity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.grzegorz.boredapi.exception.activity.ActivityError;
import pl.grzegorz.boredapi.exception.activity.ActivityException;
import pl.grzegorz.boredapi.model.entity.ActivityLog;
import pl.grzegorz.boredapi.model.entity.Activity;
import pl.grzegorz.boredapi.service.log.ActivityLogService;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ActivityHelper {

    private final ActivityLogService activityLogService;

    protected void checkPresenceActivity(List<Activity> activities, String key) {
        for (Activity activity : activities) {
            if (activity.getKey().equals(key)) {
                activityLogService.addLog(new ActivityLog(key));
                log.warn("Activity already exists in database. Time: " + LocalDateTime.now());
                throw new ActivityException(ActivityError.ACTIVITY_ALREADY_EXISTS);
            }
        }
    }
}
