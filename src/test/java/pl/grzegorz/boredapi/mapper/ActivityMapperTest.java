package pl.grzegorz.boredapi.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.grzegorz.boredapi.exception.activity.ActivityException;
import pl.grzegorz.boredapi.model.dto.ActivityDto;
import pl.grzegorz.boredapi.model.dto.ActivityDtoInfo;
import pl.grzegorz.boredapi.model.entity.Activity;

import static org.junit.jupiter.api.Assertions.*;

class ActivityMapperTest {

    private ActivityMapper activityMapper;

    @BeforeEach
    void initializeMapper() {
        activityMapper = new ActivityMapper();
    }

    @Test
    void shouldReturnNullWhenActivityDtoWillBeNull() {
//        given
        ActivityDto activityDto = null;
//        when
        try {
            activityMapper.fromDtoToEntity(activityDto);
        } catch (ActivityException e) {
//            then
            assertEquals("The request is a Null. Try again", e.getActivityError().getMessage());
        }
    }

    @Test
    void shouldReturnActivityWhenActivityDtoWillBeNotNull() {
//        given
        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivity("Some activity");
        activityDto.setAccessibility(2.3);
        activityDto.setKey("842687913");
        activityDto.setLink("https://www.some-web.pl");
        activityDto.setParticipants(4);
        activityDto.setPrice(5.6);
        activityDto.setType("Others");
//        when
        Activity activity = activityMapper.fromDtoToEntity(activityDto);
//        then
        assertAll(
                () -> assertNotNull(activity),
                () -> assertEquals("Some activity", activity.getActivity()),
                () -> assertEquals(2.3, activity.getAccessibility()),
                () -> assertEquals("842687913", activity.getKey()),
                () -> assertEquals("https://www.some-web.pl", activity.getLink()),
                () -> assertEquals(4, activity.getParticipants()),
                () -> assertEquals(5.6, activity.getPrice()),
                () -> assertEquals("Others", activity.getType())
        );
    }

    @Test
    void shouldReturnNullWhenActivityWillBeNull() {
//        given
        Activity activity = null;
//        when
        ActivityDtoInfo activityDtoInfo = activityMapper.fromEntityToDtoInfo(activity);
//        then
        assertNull(activityDtoInfo);
    }

    @Test
    void shouldReturnActivityDtoInfoWhenActivityWillBeNotNull() {
//        given
        Activity activity = new Activity();
        activity.setId(5);
        activity.setActivity("Some activity");
        activity.setAccessibility(3.4);
        activity.setKey("183631289");
        activity.setLink("https://www.some-web.pl");
        activity.setParticipants(6);
        activity.setPrice(76.8);
        activity.setType("Outdoor");
//        when
        ActivityDtoInfo activityDtoInfo = activityMapper.fromEntityToDtoInfo(activity);
//        then
        assertAll(
                () -> assertNotNull(activityDtoInfo),
                () -> assertEquals(5, activityDtoInfo.getId()),
                () -> assertEquals("Some activity", activityDtoInfo.getActivity()),
                () -> assertEquals(3.4, activityDtoInfo.getAccessibility()),
                () -> assertEquals("183631289", activityDtoInfo.getKey()),
                () -> assertEquals("https://www.some-web.pl", activity.getLink()),
                () -> assertEquals(6, activityDtoInfo.getParticipants()),
                () -> assertEquals(76.8, activityDtoInfo.getPrice()),
                () -> assertEquals("Outdoor", activityDtoInfo.getType())
        );
    }
}