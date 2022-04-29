package pl.grzegorz.boredapi.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoredDtoInfo {

    private long id;
    private String activity;
    private String type;
    private int participants;
    private double price;
    private String link;
    private String key;
    private double accessibility;
}
