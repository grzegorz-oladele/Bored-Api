package pl.grzegorz.boredapi.service;

import org.springframework.stereotype.Component;
import pl.grzegorz.boredapi.exception.bored.BoredError;
import pl.grzegorz.boredapi.exception.bored.BoredException;
import pl.grzegorz.boredapi.model.entity.BoredEntity;

import java.util.List;

@Component
public class BoredHelper {

    protected void checkPresenceActivity(List<BoredEntity> activities, String key) {
        for (BoredEntity activity : activities) {
            if (activity.getKey().equals(key)) {
                throw new BoredException(BoredError.BORED_ALREADY_EXISTS);
            }
        }
    }
}
