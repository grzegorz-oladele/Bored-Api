package pl.grzegorz.boredapi.service.log;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.grzegorz.boredapi.model.entity.Log;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {
    @Override
    public void addLog(Log log) {

    }

    @Override
    public List<Log> getAllLogs() {
        return null;
    }
}
