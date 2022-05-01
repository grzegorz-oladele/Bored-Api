package pl.grzegorz.boredapi.service.web_client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.grzegorz.boredapi.model.dto.ActivityDto;

import java.time.LocalDateTime;

/**
 * Class used to handle requests sent to https://www.boredapi.com/api/activity/
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class WebClientServiceImpl implements WebClientService {

    private final RestTemplate restTemplate;

    /**
     * Method to retrieve random activity from the bored API service database
     *
     * @return activity object mapped to java object ActivityDto
     */

    @Override
    public ActivityDto getActivityDto() {
        log.info("Request to get activity from bored API " + LocalDateTime.now());
        return restTemplate.getForObject("https://www.boredapi.com/api/activity/", ActivityDto.class);
    }
}
