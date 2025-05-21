package com.levelvini.test_dev.exceptions.treatment;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
public class ErroResponse {

    private LocalDateTime timestamp;
    private String message;
    private String httpStatus;
}
