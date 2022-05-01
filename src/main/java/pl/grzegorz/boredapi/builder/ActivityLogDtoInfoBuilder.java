package pl.grzegorz.boredapi.builder;

import pl.grzegorz.boredapi.model.dto.ActivityLogDtoInfo;

/**
 * A class whose job is to build "activity log" objects using the BUILDER design pattern.
 */
public class ActivityLogDtoInfoBuilder {

    private long id;
    private String activityKey;
    private String creationDate;

    /**
     * @param id ID of the log object in the database
     * @return object of type ActivityDtoInfoBuilder with completed ID parameter.
     */

    public ActivityLogDtoInfoBuilder withId(long id) {
        this.id = id;
        return this;
    }

    /**
     * @param activityKey that has not been saved in the database due to duplication
     * @return object of type ActivityDtoInfoBuilder with completed activityKey parameter.
     */

    public ActivityLogDtoInfoBuilder withActivityKey(String activityKey) {
        this.activityKey = activityKey;
        return this;
    }

    /**
     * @param creationDate date and time when adding a new activity to the database was blocked due to
     *                     activity duplication
     * @return object of type ActivityLogDtoInfoBuilder with completed creationDate parameter.
     */

    public ActivityLogDtoInfoBuilder withCreationDate(String creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    /**
     * The task of the method is to build a new object of ActivityLogDtoInfo type using all available parameters
     * of ActivityLogDtoInfo class.
     *
     * @return a new object of type ActivityLogDtoInfo.
     */

    public ActivityLogDtoInfo build() {
        ActivityLogDtoInfo activityLogDtoInfo = new ActivityLogDtoInfo();
        activityLogDtoInfo.setId(id);
        activityLogDtoInfo.setActivityKey(activityKey);
        activityLogDtoInfo.setCreationDate(creationDate);
        return activityLogDtoInfo;
    }
}
