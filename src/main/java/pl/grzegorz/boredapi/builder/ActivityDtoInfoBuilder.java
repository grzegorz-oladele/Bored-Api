package pl.grzegorz.boredapi.builder;

import pl.grzegorz.boredapi.model.dto.ActivityDtoInfo;

public class ActivityDtoInfoBuilder {

    private long id;
    private String activity;
    private String type;
    private int participants;
    private double price;
    private String link;
    private String key;
    private double accessibility;

    public ActivityDtoInfoBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public ActivityDtoInfoBuilder withActivity(String activity) {
        this.activity = activity;
        return this;
    }

    public ActivityDtoInfoBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public ActivityDtoInfoBuilder withParticipants(int participants) {
        this.participants = participants;
        return this;
    }

    public ActivityDtoInfoBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public ActivityDtoInfoBuilder withLink(String link) {
        this.link = link;
        return this;
    }

    public ActivityDtoInfoBuilder withKey(String key) {
        this.key = key;
        return this;
    }

    public ActivityDtoInfoBuilder withAccessibility(double accessibility) {
        this.accessibility = accessibility;
        return this;
    }

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
