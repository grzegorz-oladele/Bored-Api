package pl.grzegorz.boredapi.service.log;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.grzegorz.boredapi.mapper.ActivityLogMapper;
import pl.grzegorz.boredapi.model.dto.ActivityLogDtoInfo;
import pl.grzegorz.boredapi.model.entity.ActivityLog;
import pl.grzegorz.boredapi.repository.ActivityLogRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for adding and displaying logs to and from the database
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository activityLogRepository;
    private final ActivityLogMapper activityLogMapper;

    /**
     * The method is used to write a log to the database when a request to write a new activity cannot be satisfied
     * because an activity with the specified key already exists in the database. The method will execute
     * asynchronously in the "Task 1" thread
     *
     * @param activityLog object containing information about the activity code and the date and time when the log was
     *                    added to the database
     */

    @Async
    @Override
    public void addLog(ActivityLog activityLog) {
        log.info("Request to add log to the database " + LocalDateTime.now());
        activityLogRepository.save(activityLog);
        log.info("Save log to the database " + LocalDateTime.now());
    }

    /**
     * The purpose of this method is to retrieve all logs from the database
     *
     * @return the list of logs converted by the "toDtoInfoList" method into the list of objects
     * of ActivityLogDtoInfo type
     */

    @Override
    public List<ActivityLogDtoInfo> getAllLogs() {
        log.info("Request to get all logs from database " + LocalDateTime.now());
        List<ActivityLog> logs = activityLogRepository.findAll();
        log.info("Response to a request to return a list of all logs " + LocalDateTime.now());
        return toDtoInfoList(logs);
    }

    /**
     * This method is used to map a list of objects of type ActivityLog to a list of objects of type
     * ActivityLogDtoInfo using the injected ActivityLogMapper and the fromEntityToDtoInfo method
     *
     * @param logs list of objects of type ActivityLog
     * @return a list of objects of type ActivityLogDtoInfo
     */

    private List<ActivityLogDtoInfo> toDtoInfoList(List<ActivityLog> logs) {
        return logs
                .stream()
                .map(activityLogMapper::fromEntityToDtoInfo)
                .collect(Collectors.toList());
    }
}
