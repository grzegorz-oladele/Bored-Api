package pl.grzegorz.boredapi.service.log;

import pl.grzegorz.boredapi.model.dto.LogDtoInfo;
import pl.grzegorz.boredapi.model.entity.Log;

import java.util.List;

public interface LogService {
    
    void addLog(Log log);
    
    List<LogDtoInfo> getAllLogs();
}
