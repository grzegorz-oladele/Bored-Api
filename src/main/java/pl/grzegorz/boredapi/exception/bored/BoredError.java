package pl.grzegorz.boredapi.exception.bored;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BoredError {

    BORED_NULL("The request is a Null. Try again");

    private final String message;
}
