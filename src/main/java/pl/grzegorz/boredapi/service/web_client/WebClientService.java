package pl.grzegorz.boredapi.service.web_client;

import pl.grzegorz.boredapi.model.dto.ActivityDto;

/**
 * A markup interface for a service that deals with retrieving data from an external API
 */
public interface WebClientService {

    /**
     * Method to retrieve an activity object from an external service
     *
     * @return object of type ActivityDto
     */
    ActivityDto getActivityDto();
}
