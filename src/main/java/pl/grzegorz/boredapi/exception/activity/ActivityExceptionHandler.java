package pl.grzegorz.boredapi.exception.activity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *A class whose job is to catch the appropriate exception at runtime and pass the appropriate information
 * to the frontend application.
 */

@RestControllerAdvice
public class ActivityExceptionHandler {

    /**
     * A method to catch an ActivityException, set the appropriate response code, and display the appropriate
     * error status message.
     * @param e ActivityException object
     * @return a message depending on the situation in which the exception occurred
     */

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
