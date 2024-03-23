package com.testproject.directory.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@Builder
public class ExceptionDto {
    private String message;
    private Date timestamp;
    private HttpStatus httpStatus;
}
