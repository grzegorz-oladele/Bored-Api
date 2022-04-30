package pl.grzegorz.boredapi.exception.bored;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BoredExceptionHandler {

    @ExceptionHandler(value = BoredException.class)
    public ResponseEntity<BoredErrorInfo> handlerBoredException(BoredException e) {
        HttpStatus httpStatus = HttpStatus.MULTI_STATUS;
        if (BoredError.BORED_NULL.equals(e.getBoredError())) {
            httpStatus = HttpStatus.NO_CONTENT;
        }
        if (BoredError.BORED_ALREADY_EXISTS.equals(e.getBoredError())) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(httpStatus).body(new BoredErrorInfo(e.getBoredError().getMessage()));
    }
}
