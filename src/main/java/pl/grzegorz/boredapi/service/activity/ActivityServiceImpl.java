package pl.grzegorz.boredapi.service.activity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.grzegorz.boredapi.mapper.ActivityMapper;
import pl.grzegorz.boredapi.model.dto.ActivityDto;
import pl.grzegorz.boredapi.model.dto.ActivityDtoInfo;
import pl.grzegorz.boredapi.model.entity.Activity;
import pl.grzegorz.boredapi.repository.ActivityRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivityServiceImpl implements ActivityService {

    private final RestTemplate restTemplate;
    private final ActivityRepository activityRepository;
    private final ActivityMapper activityMapper;
    private final ActivityHelper activityHelper;

    @Override
    public ActivityDtoInfo addActivity() {
        log.info("Request to add activity to the database");
        ActivityDto activityDto = restTemplate.getForObject("https://www.boredapi.com/api/activity/", ActivityDto.class);
        activityHelper.checkPresenceActivity(getActivityList(), activityDto.getKey());
        Activity activity = activityMapper.fromDtoToEntity(activityDto);
        activityRepository.save(activity);
        log.info("Save activity to the database");
        return activityMapper.fromEntityToDtoInfo(activity);
    }

    private List<Activity> getActivityList() {
        return activityRepository.findAll();
    }
}
