package pl.grzegorz.boredapi.exception.activity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ActivityError {

    ACTIVITY_NULL("The request is a Null. Try again"),
    ACTIVITY_ALREADY_EXISTS("The activity already exists in the database. Try again.");

    private final String message;
}
