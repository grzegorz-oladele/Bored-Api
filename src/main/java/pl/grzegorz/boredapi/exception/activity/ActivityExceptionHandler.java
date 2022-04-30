package pl.grzegorz.boredapi.exception.activity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ActivityExceptionHandler {

    @ExceptionHandler(value = ActivityException.class)
    public ResponseEntity<ActivityErrorInfo> handlerBoredException(ActivityException e) {
        HttpStatus httpStatus = HttpStatus.MULTI_STATUS;
        if (ActivityError.ACTIVITY_NULL.equals(e.getActivityError())) {
            httpStatus = HttpStatus.NO_CONTENT;
        }
        if (ActivityError.ACTIVITY_ALREADY_EXISTS.equals(e.getActivityError())) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(httpStatus).body(new ActivityErrorInfo(e.getActivityError().getMessage()));
    }
}
