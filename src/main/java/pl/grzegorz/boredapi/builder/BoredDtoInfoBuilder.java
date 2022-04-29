package pl.grzegorz.boredapi.builder;

import pl.grzegorz.boredapi.model.dto.BoredDtoInfo;

public class BoredDtoInfoBuilder {

    private long id;
    private String activity;
    private String type;
    private int participants;
    private double price;
    private String link;
    private String key;
    private double accessibility;

    public BoredDtoInfoBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public BoredDtoInfoBuilder withActivity(String activity) {
        this.activity = activity;
        return this;
    }

    public BoredDtoInfoBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public BoredDtoInfoBuilder withParticipants(int participants) {
        this.participants = participants;
        return this;
    }

    public BoredDtoInfoBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public BoredDtoInfoBuilder withLink(String link) {
        this.link = link;
        return this;
    }

    public BoredDtoInfoBuilder withKey(String key) {
        this.key = key;
        return this;
    }

    public BoredDtoInfoBuilder withAccessibility(double accessibility) {
        this.accessibility = accessibility;
        return this;
    }

    public BoredDtoInfo build() {
        BoredDtoInfo boredDtoInfo = new BoredDtoInfo();
        boredDtoInfo.setId(id);
        boredDtoInfo.setActivity(activity);
        boredDtoInfo.setType(type);
        boredDtoInfo.setParticipants(participants);
        boredDtoInfo.setPrice(price);
        boredDtoInfo.setLink(link);
        boredDtoInfo.setKey(key);
        boredDtoInfo.setAccessibility(accessibility);
        return boredDtoInfo;
    }
}
