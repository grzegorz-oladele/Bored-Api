package pl.grzegorz.boredapi.service;

import pl.grzegorz.boredapi.model.dto.BoredDto;

public interface BoredService {

    BoredDto getBored();

    BoredDto addBored(BoredDto boredDto);
}
