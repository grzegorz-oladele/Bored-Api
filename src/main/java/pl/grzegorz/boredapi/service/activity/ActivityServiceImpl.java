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

/**
 * A class used to process, pass to the controller and store in the database information related to activities
 * downloaded from the external API
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;
    private final ActivityMapper activityMapper;
    private final WebClientService webClientService;
    private final ActivityLogService activityLogService;

    /**
     * The purpose of the method is to add a new activity to the method database. If the activity already exists
     * in the database it will not be written again. The user will be informed and asked to download the activity again.
     *
     * @return ActivityDtoInfo object using method fromActivityMapper class.
     * @throws ActivityException when the downloaded activity is already in the database.
     *                           Validation is performed on the activity key value
     */

    @Override
    @Transactional
    //FIXME this method does more than one thing - divide into smaller
    public ActivityDtoInfo addActivity() {
        log.info("Request to add activity to the database " + LocalDateTime.now());
        ActivityDto activityDto = webClientService.getActivityDto();
        checkKey(activityDto.getKey());
        Activity activity = activityMapper.fromDtoToEntity(activityDto);
        activityRepository.save(activity);
        log.info("Save activity to the database " + LocalDateTime.now());
        return activityMapper.fromEntityToDtoInfo(activity);
    }

    /**
     * The purpose of the method is to throw an exception when the activity with the specified key already exists
     * in the database
     *
     * @param key a unique key assigned to the activity
     */
//TODO checkKeyAndThrowExceptionIfExists
    protected void checkKey(String key) {
        if (existsByKey(key)) {
            activityLogService.addLog(new ActivityLog(key));
            log.warn("Activity already exists in database. Time: " + LocalDateTime.now());
            throw new ActivityException(ActivityError.ACTIVITY_ALREADY_EXISTS);
        }
    }

    /**
     * The purpose of the method is to check if there is an activity in the database with the given key value
     *
     * @param key a unique key assigned to the activity
     * @return true if activity with specified key is already in the database or false if such activity is not
     * in the database
     */

    private boolean existsByKey(String key) {
        return activityRepository.existsByKey(key);
    }
}
