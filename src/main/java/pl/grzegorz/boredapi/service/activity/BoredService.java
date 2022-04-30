package pl.grzegorz.boredapi.service.activity;

import pl.grzegorz.boredapi.model.dto.BoredDto;
import pl.grzegorz.boredapi.model.dto.BoredDtoInfo;

public interface BoredService {

    BoredDto getBored();

    BoredDtoInfo addBored();
}
