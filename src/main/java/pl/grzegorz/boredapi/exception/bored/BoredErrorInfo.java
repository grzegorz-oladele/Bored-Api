package pl.grzegorz.boredapi.exception.bored;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BoredErrorInfo {

    private final String message;
}
