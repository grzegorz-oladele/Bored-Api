package pl.grzegorz.boredapi.service.log;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.grzegorz.boredapi.mapper.LogMapper;
import pl.grzegorz.boredapi.model.dto.LogDtoInfo;
import pl.grzegorz.boredapi.model.entity.ActivityLog;
import pl.grzegorz.boredapi.repository.LogRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;
    private final LogMapper logMapper;

    @Async
    @Override
    public void addLog(ActivityLog activityLog) {
        log.info("Request to add log to the database");
        logRepository.save(activityLog);
        log.info("Save log to the database");
    }

    @Override
    public List<LogDtoInfo> getAllLogs() {
        List<ActivityLog> logs = logRepository.findAll();
        return toDtoInfoList(logs);
    }

    private List<LogDtoInfo> toDtoInfoList(List<ActivityLog> logs) {
        return logs
                .stream()
                .map(logMapper::fromEntityToDtoInfo)
                .collect(Collectors.toList());
    }
}
