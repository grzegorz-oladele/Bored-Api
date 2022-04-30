package pl.grzegorz.boredapi.exception.bored;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BoredError {

    BORED_NULL("The request is a Null. Try again"),
    BORED_ALREADY_EXISTS("The activity already exists in the database. Try again.");

    private final String message;
}
