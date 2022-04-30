package pl.grzegorz.boredapi.builder;

import pl.grzegorz.boredapi.model.dto.LogDtoInfo;

public class LogDtoInfoBuilder {

    private long id;
    private String activityKey;
    private String creationDate;

    public LogDtoInfoBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public LogDtoInfoBuilder withActivityKey(String activityKey) {
        this.activityKey = activityKey;
        return this;
    }

    public LogDtoInfoBuilder withCreationDate(String creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public LogDtoInfo build() {
        LogDtoInfo logDtoInfo = new LogDtoInfo();
        logDtoInfo.setId(id);
        logDtoInfo.setActivityKey(activityKey);
        logDtoInfo.setCreationDate(creationDate);
        return logDtoInfo;
    }
}
