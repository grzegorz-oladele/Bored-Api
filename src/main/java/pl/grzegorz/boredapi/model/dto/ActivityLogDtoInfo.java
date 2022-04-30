package pl.grzegorz.boredapi.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActivityLogDtoInfo {

    private long id;
    private String activityKey;
    private String creationDate;
}
