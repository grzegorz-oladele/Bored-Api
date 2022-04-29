package pl.grzegorz.boredapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.grzegorz.boredapi.mapper.BoredMapper;
import pl.grzegorz.boredapi.model.dto.BoredDto;
import pl.grzegorz.boredapi.model.entity.BoredEntity;
import pl.grzegorz.boredapi.repository.BoredRepository;

@Service
@RequiredArgsConstructor
public class BoredServiceImpl implements BoredService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final BoredRepository boredRepository;
    private final BoredMapper boredMapper;

    @Override
    public BoredDto getBored() {
        BoredDto response = restTemplate.getForObject("https://www.boredapi.com/api/activity/", BoredDto.class);
        return objectMapper.convertValue(response, BoredDto.class);
    }

    @Override
    public BoredDto addBored(BoredDto boredDto) {
        BoredEntity boredEntity = boredMapper.fromDtoToEntity(boredDto);
        boredRepository.save(boredEntity);
        return null;
    }
}
