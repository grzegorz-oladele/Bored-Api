package pl.grzegorz.boredapi.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "activities")
public class BoredEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String activity;
    private String type;
    private int participants;
    private double price;
    private String link;
    @Column(name = "bored_key")
    private String key;
    private double accessibility;
}
