package pl.grzegorz.boredapi.service;

import pl.grzegorz.boredapi.model.dto.BoredDto;
import pl.grzegorz.boredapi.model.dto.BoredDtoInfo;

public interface BoredService {

    BoredDto getBored();

    BoredDtoInfo addBored(BoredDto boredDto);
}
