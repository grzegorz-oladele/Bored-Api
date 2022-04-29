package pl.grzegorz.boredapi.mapper;

import org.springframework.stereotype.Component;
import pl.grzegorz.boredapi.builder.BoredDtoInfoBuilder;
import pl.grzegorz.boredapi.builder.BoredEntityBuilder;
import pl.grzegorz.boredapi.exception.bored.BoredError;
import pl.grzegorz.boredapi.exception.bored.BoredException;
import pl.grzegorz.boredapi.model.dto.BoredDto;
import pl.grzegorz.boredapi.model.dto.BoredDtoInfo;
import pl.grzegorz.boredapi.model.entity.BoredEntity;

import java.util.Objects;

@Component
public class BoredMapper {

    public BoredEntity fromDtoToEntity(BoredDto boredDto) {
        if (boredDto == null) {
            throw new BoredException(BoredError.BORED_NULL);
        }
        BoredEntityBuilder boredEntityBuilder = new BoredEntityBuilder();
        if (Objects.nonNull(boredDto.getActivity())) {
            boredEntityBuilder.withActivity(boredDto.getActivity());
        }
        if (Objects.nonNull(boredDto.getType())) {
            boredEntityBuilder.withType(boredDto.getType());
        }
        if (boredDto.getParticipants() > 0) {
            boredEntityBuilder.withParticipants(boredDto.getParticipants());
        }
        if (boredDto.getPrice() > 0) {
            boredEntityBuilder.withPrice(boredDto.getPrice());
        }
        if (Objects.nonNull(boredDto.getLink())) {
            boredEntityBuilder.withLink(boredDto.getLink());
        }
        if (Objects.nonNull(boredDto.getKey())) {
            boredEntityBuilder.withKey(boredDto.getKey());
        }
        if (boredDto.getAccessibility() > 0) {
            boredEntityBuilder.withAccessibility(boredDto.getAccessibility());
        }
        return boredEntityBuilder.build();
    }

    public BoredDtoInfo fromEntityToDtoInfo(BoredEntity boredEntity) {
        if (boredEntity == null) {
            return null;
        }
        BoredDtoInfoBuilder boredDtoInfoBuilder = new BoredDtoInfoBuilder();
        if (boredEntity.getId() > 0) {
            boredDtoInfoBuilder.withId(boredEntity.getId());
        }
        if (Objects.nonNull(boredEntity.getActivity())) {
            boredDtoInfoBuilder.withActivity(boredEntity.getActivity());
        }
        if (Objects.nonNull(boredEntity.getType())) {
            boredDtoInfoBuilder.withType(boredEntity.getType());
        }
        if (boredEntity.getParticipants() > 0) {
            boredDtoInfoBuilder.withParticipants(boredEntity.getParticipants());
        }
        if (boredEntity.getPrice() > 0) {
            boredDtoInfoBuilder.withPrice(boredEntity.getPrice());
        }
        if (Objects.nonNull(boredEntity.getLink())) {
            boredDtoInfoBuilder.withLink(boredEntity.getLink());
        }
        if (Objects.nonNull(boredEntity.getKey())) {
            boredDtoInfoBuilder.withKey(boredEntity.getKey());
        }
        if (boredEntity.getAccessibility() > 0) {
            boredDtoInfoBuilder.withAccessibility(boredEntity.getAccessibility());
        }
        return boredDtoInfoBuilder.build();
    }
}
