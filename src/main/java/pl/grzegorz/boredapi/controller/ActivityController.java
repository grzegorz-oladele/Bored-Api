package pl.grzegorz.boredapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.grzegorz.boredapi.model.dto.ActivityDtoInfo;
import pl.grzegorz.boredapi.service.activity.ActivityService;

/**
 * Controller class used to communicate between the frontend application and the activity part of the service
 */

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    /**
     * Method that adds an activity object downloaded from an external service to the database.
     * The whole operation is preceded by a validation to avoid duplicate records. in the database
     *
     * @return a mapped activity object
     */

    @GetMapping
    public ActivityDtoInfo addActivity() {
        return activityService.addActivity();
    }
}
