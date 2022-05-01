package pl.grzegorz.boredapi.exception.activity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * A class that aggregates all the types of exceptions that can occur during the course of an application
 */

@Getter
@RequiredArgsConstructor
public enum ActivityError {

    ACTIVITY_NULL("The request is a Null. Try again"),
    ACTIVITY_ALREADY_EXISTS("The activity already exists in the database. Try again.");

    private final String message;
}
