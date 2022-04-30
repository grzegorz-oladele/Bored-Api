package pl.grzegorz.boredapi.mapper;

import org.springframework.stereotype.Component;
import pl.grzegorz.boredapi.builder.LogDtoInfoBuilder;
import pl.grzegorz.boredapi.model.dto.LogDtoInfo;
import pl.grzegorz.boredapi.model.entity.ActivityLog;

import java.util.Objects;

@Component
public class LogMapper {

    public LogDtoInfo fromEntityToDtoInfo(ActivityLog log) {
        if (log == null) {
            return null;
        }
        LogDtoInfoBuilder logDtoInfoBuilder = new LogDtoInfoBuilder();
        if (log.getId() > 0) {
            logDtoInfoBuilder.withId(log.getId());
        }
        if (Objects.nonNull(log.getActivityKey())) {
            logDtoInfoBuilder.withActivityKey(log.getActivityKey());
        }
        if (Objects.nonNull(log.getCreationDate())) {
            logDtoInfoBuilder.withCreationDate(log.getCreationDate().toString());
        }
        return logDtoInfoBuilder.build();
    }
}
