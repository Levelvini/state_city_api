package com.levelvini.test_dev.exceptions.treatment;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErroResponse {
    private String message;
    private LocalDateTime timestamp;
    private HttpStatus httpStatus;
}
