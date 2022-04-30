package pl.grzegorz.boredapi.service.log;

import  lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.grzegorz.boredapi.model.entity.Log;
import pl.grzegorz.boredapi.repository.LogRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Async
    @Override
    public void addLog(Log log) {
        logRepository.save(log);
    }

    @Override
    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }
}
