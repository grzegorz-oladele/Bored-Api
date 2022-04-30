package pl.grzegorz.boredapi.service.activity;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.grzegorz.boredapi.mapper.BoredMapper;
import pl.grzegorz.boredapi.model.dto.BoredDto;
import pl.grzegorz.boredapi.model.dto.BoredDtoInfo;
import pl.grzegorz.boredapi.model.entity.BoredEntity;
import pl.grzegorz.boredapi.repository.BoredRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoredServiceImpl implements BoredService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final BoredRepository boredRepository;
    private final BoredMapper boredMapper;
    private final BoredHelper boredHelper;

    @Override
    public BoredDto getBored() {
        return null;
    }

    @Override
    public BoredDtoInfo addBored() {
        log.info("Request to add activity to the database");
        BoredDto boredDto = restTemplate.getForObject("https://www.boredapi.com/api/activity/", BoredDto.class);
        boredHelper.checkPresenceActivity(getBoredList(), boredDto.getKey());
        BoredEntity boredEntity = boredMapper.fromDtoToEntity(boredDto);
        boredRepository.save(boredEntity);
        log.info("Save activity to the database");
        return boredMapper.fromEntityToDtoInfo(boredEntity);
    }

    private List<BoredEntity> getBoredList() {
        return boredRepository.findAll();
    }
}
