package pl.grzegorz.boredapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.grzegorz.boredapi.model.BoredDto;

@Service
@RequiredArgsConstructor
public class BoredServiceImpl implements BoredService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public BoredDto getBored() {
        BoredDto response = restTemplate.getForObject("https://www.boredapi.com/api/activity/", BoredDto.class);
        return objectMapper.convertValue(response, BoredDto.class);
    }
}
