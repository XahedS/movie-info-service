package example.microservice.movieinfoservice.exception;

import example.microservice.movieinfoservice.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientException;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
@ResponseBody
public class GlobalException {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiError handleException(Exception ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex);
    }

    @ExceptionHandler(RestClientException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiError handleException(RestClientException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex);
    }

    private ApiError buildErrorResponse(HttpStatus status, Throwable ex) {
        return new ApiError() {{
            setTimestamp(LocalDateTime.now());
            setStatus(status.getReasonPhrase());
            setMessage(ex.getMessage());
        }};
    }
}
