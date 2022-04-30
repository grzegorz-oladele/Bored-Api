package pl.grzegorz.boredapi.service.activity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.grzegorz.boredapi.exception.bored.BoredError;
import pl.grzegorz.boredapi.exception.bored.BoredException;
import pl.grzegorz.boredapi.model.entity.ActivityLog;
import pl.grzegorz.boredapi.model.entity.BoredEntity;
import pl.grzegorz.boredapi.service.log.LogService;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class BoredHelper {

    private final LogService logService;

    protected void checkPresenceActivity(List<BoredEntity> activities, String key) {
        for (BoredEntity activity : activities) {
            if (activity.getKey().equals(key)) {
                logService.addLog(new ActivityLog(key));
                log.warn("Activity already exists in database. Time: " + LocalDateTime.now());
                throw new BoredException(BoredError.BORED_ALREADY_EXISTS);
            }
        }
    }
}
