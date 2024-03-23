package com.testproject.directory;

import com.testproject.directory.exception.ExceptionDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ExceptionDto exceptionDto(Exception e) {
        return ExceptionDto.builder()
                .message(e.getMessage())
                .timestamp(new Date())
                .httpStatus(INTERNAL_SERVER_ERROR)
                .build();
    }

}
