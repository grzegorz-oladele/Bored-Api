package pl.grzegorz.boredapi.exception.activity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ActivityErrorInfo {

    private final String message;
}
