package pl.grzegorz.boredapi.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String activityKey;
    private LocalDateTime creationDate;

    @PrePersist
    public void createdOn() {
        this.creationDate = LocalDateTime.now();
    }
}
