package pl.grzegorz.boredapi.service.log;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.grzegorz.boredapi.mapper.ActivityLogMapper;
import pl.grzegorz.boredapi.model.dto.ActivityLogDtoInfo;
import pl.grzegorz.boredapi.model.entity.ActivityLog;
import pl.grzegorz.boredapi.repository.ActivityLogRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository activityLogRepository;
    private final ActivityLogMapper activityLogMapper;

    @Async
    @Override
    public void addLog(ActivityLog activityLog) {
        log.info("Request to add log to the database");
        activityLogRepository.save(activityLog);
        log.info("Save log to the database");
    }

    @Override
    public List<ActivityLogDtoInfo> getAllLogs() {
        List<ActivityLog> logs = activityLogRepository.findAll();
        return toDtoInfoList(logs);
    }

    private List<ActivityLogDtoInfo> toDtoInfoList(List<ActivityLog> logs) {
        return logs
                .stream()
                .map(activityLogMapper::fromEntityToDtoInfo)
                .collect(Collectors.toList());
    }
}
