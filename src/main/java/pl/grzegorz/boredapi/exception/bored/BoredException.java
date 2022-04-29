package pl.grzegorz.boredapi.exception.bored;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BoredException extends RuntimeException {

    private final BoredError boredError;
}
