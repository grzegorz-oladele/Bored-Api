package pl.grzegorz.boredapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.grzegorz.boredapi.model.dto.ActivityLogDtoInfo;
import pl.grzegorz.boredapi.service.log.ActivityLogService;

import java.util.List;

/**
 * Controller class responsible for handling the display of application logs
 */

@RestController
@RequestMapping("/api/logs")
@RequiredArgsConstructor
public class ActivityLogController {

    private final ActivityLogService activityLogService;

    /**
     * The purpose of this method is to pass all logs from the database to the frontend application
     *
     * @return list of logs from database
     */

    @GetMapping
    public List<ActivityLogDtoInfo> getAllLogs() {
        return activityLogService.getAllLogs();
    }
}
