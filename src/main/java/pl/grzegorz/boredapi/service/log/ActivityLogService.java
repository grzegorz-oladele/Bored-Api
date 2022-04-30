package pl.grzegorz.boredapi.service.log;

import pl.grzegorz.boredapi.model.dto.ActivityLogDtoInfo;
import pl.grzegorz.boredapi.model.entity.ActivityLog;

import java.util.List;

public interface ActivityLogService {
    
    void addLog(ActivityLog log);
    
    List<ActivityLogDtoInfo> getAllLogs();
}
