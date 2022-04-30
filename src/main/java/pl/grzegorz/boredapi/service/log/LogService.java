package pl.grzegorz.boredapi.service.log;

import pl.grzegorz.boredapi.model.dto.LogDtoInfo;
import pl.grzegorz.boredapi.model.entity.ActivityLog;

import java.util.List;

public interface LogService {
    
    void addLog(ActivityLog log);
    
    List<LogDtoInfo> getAllLogs();
}
