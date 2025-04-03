package hieu.statisticservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleException(Exception ex) {
        Map<String, String> map = new HashMap<>();
        log.error("An unexpected error occurred: {}", ex.getMessage());
        map.put("cause", String.valueOf(ex.getCause()));
        map.put("message", ex.getMessage());
        map.put("code", "400");
        return map;
    }
}
