package pl.grzegorz.boredapi.builder;

import pl.grzegorz.boredapi.model.dto.ActivityDtoInfo;

/**
 * A class whose task is to create an object of the ActivityDtoInfo type using the BUILDER design pattern.
 * Object of type ActivityDtoInfo will be used when displaying the processed data in the frontend application.
 */

public class ActivityDtoInfoBuilder {

    private long id;
    private String activity;
    private String type;
    private int participants;
    private double price;
    private String link;
    private String key;
    private double accessibility;

    /**
     * @param id object ID in the database of an application that processes data from the bored API.
     * @return object of type ActivityDtoInfoBuilder with completed ID parameter.
     */

    public ActivityDtoInfoBuilder withId(long id) {
        this.id = id;
        return this;
    }

    /**
     * @param activity description of activities
     * @return object of type ActivityDtoInfoBuilder with completed activity parameter
     */

    public ActivityDtoInfoBuilder withActivity(String activity) {
        this.activity = activity;
        return this;
    }

    /**
     * @param type type of activity
     * @return object of type ActivityDtoInfoBuilder with completed type parameter
     */


    public ActivityDtoInfoBuilder withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * @param participants number of participants
     * @return object of type ActivityDtoInfoBuilder with completed participants parameter
     */

    public ActivityDtoInfoBuilder withParticipants(int participants) {
        this.participants = participants;
        return this;
    }

    /**
     * @param price price of activity
     * @return object of type ActivityDtoInfoBuilder with completed price parameter
     */

    public ActivityDtoInfoBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    /**
     * @param link link to activity description
     * @return object of type ActivityDtoInfoBuilder with completed link parameter
     */

    public ActivityDtoInfoBuilder withLink(String link) {
        this.link = link;
        return this;
    }

    /**
     * @param key key of activity in database connecting with https://www.boredapi.com/api/activity/
     * @return object of type ActivityDtoInfoBuilder with completed key parameter
     */

    public ActivityDtoInfoBuilder withKey(String key) {
        this.key = key;
        return this;
    }

    /**
     * @param accessibility determines the availability of
     * @return object of type ActivityDtoInfoBuilder with completed accessibility parameter
     */

    public ActivityDtoInfoBuilder withAccessibility(double accessibility) {
        this.accessibility = accessibility;
        return this;
    }

    /**
     * The task of the method is to build a new object of ActivityDtoInfo type using all available parameters
     * of ActivityDtoInfo class.
     * @return a new object of type ActivityDtoInfo.
     */

    public ActivityDtoInfo build() {
        ActivityDtoInfo activityDtoInfo = new ActivityDtoInfo();
        activityDtoInfo.setId(id);
        activityDtoInfo.setActivity(activity);
        activityDtoInfo.setType(type);
        activityDtoInfo.setParticipants(participants);
        activityDtoInfo.setPrice(price);
        activityDtoInfo.setLink(link);
        activityDtoInfo.setKey(key);
        activityDtoInfo.setAccessibility(accessibility);
        return activityDtoInfo;
    }
}
