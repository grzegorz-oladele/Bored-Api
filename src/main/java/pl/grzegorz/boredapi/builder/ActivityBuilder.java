package pl.grzegorz.boredapi.builder;

import pl.grzegorz.boredapi.model.entity.Activity;

/**
 * A class whose task is to create an object of the Activity type using the BUILDER design pattern.
 */

public class ActivityBuilder {

    private String activity;
    private String type;
    private int participants;
    private double price;
    private String link;
    private String key;
    private double accessibility;

    /**
     * @param activity description of activities
     * @return object of type ActivityBuilder with completed activity parameter
     */

    public ActivityBuilder withActivity(String activity) {
        this.activity = activity;
        return this;
    }

    /**
     * @param type type of activity
     * @return object of type ActivityBuilder with completed type parameter
     */

    public ActivityBuilder withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * @param participants number of participants
     * @return object of type ActivityBuilder with completed participants parameter
     */

    public ActivityBuilder withParticipants(int participants) {
        this.participants = participants;
        return this;
    }

    /**
     * @param price price of activity
     * @return object of type ActivityBuilder with completed price parameter
     */

    public ActivityBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    /**
     * @param link link to activity description
     * @return object of type ActivityBuilder with completed link parameter
     */

    public ActivityBuilder withLink(String link) {
        this.link = link;
        return this;
    }

    /**
     * @param key key of activity in database connecting with https://www.boredapi.com/api/activity/
     * @return object of type ActivityBuilder with completed key parameter
     */

    public ActivityBuilder withKey(String key) {
        this.key = key;
        return this;
    }

    /**
     * @param accessibility determines the availability of
     * @return object of type ActivityBuilder with completed accessibility parameter
     */

    public ActivityBuilder withAccessibility(double accessibility) {
        this.accessibility = accessibility;
        return this;
    }

    /**
     * The task of the method is to build a new object of Activity type using all available parameters of Activity class.
     *
     * @return a new object of type Activity.
     */

    public Activity build() {
        Activity activity = new Activity();
        activity.setActivity(this.activity);
        activity.setType(type);
        activity.setParticipants(participants);
        activity.setPrice(price);
        activity.setLink(link);
        activity.setKey(key);
        activity.setAccessibility(accessibility);
        return activity;
    }
}
