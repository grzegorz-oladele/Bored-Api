package pl.grzegorz.boredapi.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogDtoInfo {

    private long id;
    private String activityKey;
    private String creationDate;
    private String creationTime;
}
