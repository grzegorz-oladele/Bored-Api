package pl.grzegorz.boredapi.builder;

import pl.grzegorz.boredapi.model.dto.ActivityLogDtoInfo;

public class ActivityLogDtoInfoBuilder {

    private long id;
    private String activityKey;
    private String creationDate;

    public ActivityLogDtoInfoBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public ActivityLogDtoInfoBuilder withActivityKey(String activityKey) {
        this.activityKey = activityKey;
        return this;
    }

    public ActivityLogDtoInfoBuilder withCreationDate(String creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public ActivityLogDtoInfo build() {
        ActivityLogDtoInfo activityLogDtoInfo = new ActivityLogDtoInfo();
        activityLogDtoInfo.setId(id);
        activityLogDtoInfo.setActivityKey(activityKey);
        activityLogDtoInfo.setCreationDate(creationDate);
        return activityLogDtoInfo;
    }
}
