package pl.grzegorz.boredapi.service.activity;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import pl.grzegorz.boredapi.mapper.BoredMapper;
import pl.grzegorz.boredapi.model.dto.BoredDto;
import pl.grzegorz.boredapi.model.dto.BoredDtoInfo;
import pl.grzegorz.boredapi.model.entity.BoredEntity;
import pl.grzegorz.boredapi.model.entity.Log;
import pl.grzegorz.boredapi.repository.BoredRepository;
import pl.grzegorz.boredapi.service.log.LogService;

import java.util.List;

@Service
@RequiredArgsConstructor
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
        BoredDto boredDto = restTemplate.getForObject("https://www.boredapi.com/api/activity/", BoredDto.class);
        boredHelper.checkPresenceActivity(getBoredList(), boredDto.getKey());
        BoredEntity boredEntity = boredMapper.fromDtoToEntity(boredDto);
        boredRepository.save(boredEntity);
        return boredMapper.fromEntityToDtoInfo(boredEntity);
    }

    private List<BoredEntity> getBoredList() {
        return boredRepository.findAll();
    }
}
