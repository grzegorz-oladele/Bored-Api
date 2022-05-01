package pl.grzegorz.boredapi.service.activity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.grzegorz.boredapi.exception.activity.ActivityError;
import pl.grzegorz.boredapi.exception.activity.ActivityException;
import pl.grzegorz.boredapi.mapper.ActivityMapper;
import pl.grzegorz.boredapi.model.dto.ActivityDto;
import pl.grzegorz.boredapi.model.dto.ActivityDtoInfo;
import pl.grzegorz.boredapi.model.entity.Activity;
import pl.grzegorz.boredapi.model.entity.ActivityLog;
import pl.grzegorz.boredapi.repository.ActivityRepository;
import pl.grzegorz.boredapi.service.log.ActivityLogService;
import pl.grzegorz.boredapi.service.web_client.WebClientService;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;
    private final ActivityMapper activityMapper;
    private final WebClientService webClientService;
    private final ActivityLogService activityLogService;

    @Override
    @Transactional
    public ActivityDtoInfo addActivity() {
        log.info("Request to add activity to the database " + LocalDateTime.now());
        ActivityDto activityDto = webClientService.getActivityDto();
        checkKey(activityDto.getKey());
        Activity activity = activityMapper.fromDtoToEntity(activityDto);
        activityRepository.save(activity);
        log.info("Save activity to the database " + LocalDateTime.now());
        return activityMapper.fromEntityToDtoInfo(activity);
    }

    protected void checkKey(String key) {
        if (existsByKey(key)) {
            activityLogService.addLog(new ActivityLog(key));
            log.warn("Activity already exists in database. Time: " + LocalDateTime.now());
            throw new ActivityException(ActivityError.ACTIVITY_ALREADY_EXISTS);
        }
    }

    private boolean existsByKey(String key) {
        return activityRepository.existsByKey(key);
    }
}
