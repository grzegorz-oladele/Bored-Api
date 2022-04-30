package pl.grzegorz.boredapi.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "activity_logs")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String activityKey;
    private LocalDateTime creationDate;

    public ActivityLog(String activityKey) {
        this.activityKey = activityKey;
    }

    @PrePersist
    public void createdOn() {
        this.creationDate = LocalDateTime.now();
    }
}
