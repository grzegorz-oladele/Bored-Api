package pl.grzegorz.boredapi.service.activity;

import pl.grzegorz.boredapi.model.dto.ActivityDtoInfo;

public interface ActivityService {

    ActivityDtoInfo addActivity();

    boolean check(String key);
}
