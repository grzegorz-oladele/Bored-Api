package pl.grzegorz.boredapi.exception.activity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ActivityException extends RuntimeException {

    private final ActivityError activityError;
}
