package pl.grzegorz.boredapi.service.activity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.grzegorz.boredapi.exception.bored.BoredError;
import pl.grzegorz.boredapi.exception.bored.BoredException;
import pl.grzegorz.boredapi.model.entity.BoredEntity;
import pl.grzegorz.boredapi.model.entity.Log;
import pl.grzegorz.boredapi.service.log.LogService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BoredHelper {

    private final LogService logService;

    protected void checkPresenceActivity(List<BoredEntity> activities, String key) {
        for (BoredEntity activity : activities) {
            if (activity.getKey().equals(key)) {
                logService.addLog(new Log(key));
                throw new BoredException(BoredError.BORED_ALREADY_EXISTS);
            }
        }
    }
}
