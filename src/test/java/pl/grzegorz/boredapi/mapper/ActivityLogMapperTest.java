package pl.grzegorz.boredapi.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.grzegorz.boredapi.model.dto.ActivityDtoInfo;
import pl.grzegorz.boredapi.model.dto.ActivityLogDtoInfo;
import pl.grzegorz.boredapi.model.entity.ActivityLog;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ActivityLogMapperTest {

    private ActivityLogMapper activityLogMapper;

    @BeforeEach
    void initializeMapper() {
        activityLogMapper = new ActivityLogMapper();
    }

    @Test
    void shouldReturnNullWhenActivityLogWillBeNull() {
//        given
        ActivityLog activityLog = null;
//        when
        ActivityLogDtoInfo activityLogDtoInfo = activityLogMapper.fromEntityToDtoInfo(activityLog);
//        then
        assertNull(activityLogDtoInfo);
    }

    @Test
    void shouldReturnActivityLogDtoInfoWhenActivityLogWillBeNotNull() {
//        given
        ActivityLog activityLog = new ActivityLog();
        activityLog.setId(3);
        activityLog.setActivityKey("1827663598");
        activityLog.setCreationDate(LocalDateTime.parse("2022-05-01T13:30:00"));
//        when
        ActivityLogDtoInfo activityLogDtoInfo = activityLogMapper.fromEntityToDtoInfo(activityLog);
//        then
        assertAll(
                () -> assertNotNull(activityLogDtoInfo),
                () -> assertEquals(3, activityLogDtoInfo.getId()),
                () -> assertEquals("1827663598", activityLogDtoInfo.getActivityKey()),
                () -> assertEquals(String.valueOf(LocalDateTime.parse("2022-05-01T13:30:00")), activityLogDtoInfo.getCreationDate())
        );
    }
}