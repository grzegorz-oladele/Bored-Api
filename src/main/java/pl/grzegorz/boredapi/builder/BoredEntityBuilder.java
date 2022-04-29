package pl.grzegorz.boredapi.builder;

import pl.grzegorz.boredapi.model.entity.BoredEntity;

public class BoredEntityBuilder {

    private String activity;
    private String type;
    private int participants;
    private double price;
    private String link;
    private String key;
    private double accessibility;

    public BoredEntityBuilder withActivity(String activity) {
        this.activity = activity;
        return this;
    }

    public BoredEntityBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public BoredEntityBuilder withParticipants(int participants) {
        this.participants = participants;
        return this;
    }

    public BoredEntityBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public BoredEntityBuilder withLink(String link) {
        this.link = link;
        return this;
    }

    public BoredEntityBuilder withKey(String key) {
        this.key = key;
        return this;
    }

    public BoredEntityBuilder withAccessibility(double accessibility) {
        this.accessibility = accessibility;
        return this;
    }

    public BoredEntity build() {
        BoredEntity boredEntity = new BoredEntity();
        boredEntity.setActivity(activity);
        boredEntity.setType(type);
        boredEntity.setParticipants(participants);
        boredEntity.setPrice(price);
        boredEntity.setLink(link);
        boredEntity.setKey(key);
        boredEntity.setAccessibility(accessibility);
        return boredEntity;
    }
}
