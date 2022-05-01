package pl.grzegorz.boredapi.mapper;

import org.springframework.stereotype.Component;
import pl.grzegorz.boredapi.builder.ActivityBuilder;
import pl.grzegorz.boredapi.builder.ActivityDtoInfoBuilder;
import pl.grzegorz.boredapi.exception.activity.ActivityError;
import pl.grzegorz.boredapi.exception.activity.ActivityException;
import pl.grzegorz.boredapi.model.dto.ActivityDto;
import pl.grzegorz.boredapi.model.dto.ActivityDtoInfo;
import pl.grzegorz.boredapi.model.entity.Activity;

import java.util.Objects;

/**
 * Class provides methods to map Activity and ActivityDto objects
 */

@Component
public class ActivityMapper {

    /**
     * Method to map an object of type ActivityDto an object of type Activity, which will be stored in the database.
     * The object of ActivityDto type cannot be NULL (the method throws an exception)
     *
     * @param activityDto object retrieved from https://www.boredapi.com/api/activity
     * @return new object of type Activity
     */

    public Activity fromDtoToEntity(ActivityDto activityDto) {
        if (activityDto == null) {
            throw new ActivityException(ActivityError.ACTIVITY_NULL);
        }
        ActivityBuilder activityBuilder = new ActivityBuilder();
        if (Objects.nonNull(activityDto.getActivity())) {
            activityBuilder.withActivity(activityDto.getActivity());
        }
        if (Objects.nonNull(activityDto.getType())) {
            activityBuilder.withType(activityDto.getType());
        }
        if (activityDto.getParticipants() > 0) {
            activityBuilder.withParticipants(activityDto.getParticipants());
        }
        if (activityDto.getPrice() > 0) {
            activityBuilder.withPrice(activityDto.getPrice());
        }
        if (Objects.nonNull(activityDto.getLink())) {
            activityBuilder.withLink(activityDto.getLink());
        }
        if (Objects.nonNull(activityDto.getKey())) {
            activityBuilder.withKey(activityDto.getKey());
        }
        if (activityDto.getAccessibility() > 0) {
            activityBuilder.withAccessibility(activityDto.getAccessibility());
        }
        return activityBuilder.build();
    }

    /**
     * Method used to map an Activity object to an ActivityDtoInfo object to be displayed in a frontend application
     *
     * @param activity object retrieved from database
     * @return new object of type ActivityDtoInfo
     */

    public ActivityDtoInfo fromEntityToDtoInfo(Activity activity) {
        if (activity == null) {
            return null;
        }
        ActivityDtoInfoBuilder activityDtoInfoBuilder = new ActivityDtoInfoBuilder();
        if (activity.getId() > 0) {
            activityDtoInfoBuilder.withId(activity.getId());
        }
        if (Objects.nonNull(activity.getActivity())) {
            activityDtoInfoBuilder.withActivity(activity.getActivity());
        }
        if (Objects.nonNull(activity.getType())) {
            activityDtoInfoBuilder.withType(activity.getType());
        }
        if (activity.getParticipants() > 0) {
            activityDtoInfoBuilder.withParticipants(activity.getParticipants());
        }
        if (activity.getPrice() > 0) {
            activityDtoInfoBuilder.withPrice(activity.getPrice());
        }
        if (Objects.nonNull(activity.getLink())) {
            activityDtoInfoBuilder.withLink(activity.getLink());
        }
        if (Objects.nonNull(activity.getKey())) {
            activityDtoInfoBuilder.withKey(activity.getKey());
        }
        if (activity.getAccessibility() > 0) {
            activityDtoInfoBuilder.withAccessibility(activity.getAccessibility());
        }
        return activityDtoInfoBuilder.build();
    }
}
