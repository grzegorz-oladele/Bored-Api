package pl.grzegorz.boredapi.builder;

import pl.grzegorz.boredapi.model.entity.Activity;

public class ActivityBuilder {

    private String activity;
    private String type;
    private int participants;
    private double price;
    private String link;
    private String key;
    private double accessibility;

    public ActivityBuilder withActivity(String activity) {
        this.activity = activity;
        return this;
    }

    public ActivityBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public ActivityBuilder withParticipants(int participants) {
        this.participants = participants;
        return this;
    }

    public ActivityBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public ActivityBuilder withLink(String link) {
        this.link = link;
        return this;
    }

    public ActivityBuilder withKey(String key) {
        this.key = key;
        return this;
    }

    public ActivityBuilder withAccessibility(double accessibility) {
        this.accessibility = accessibility;
        return this;
    }

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
