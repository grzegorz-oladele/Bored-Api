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
        return null;
    }
}
