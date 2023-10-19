package com.demo.wordhub.Handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * TODO
 *
 * @author OuOu
 * @version 1.0
 */
@RestControllerAdvice
@Slf4j
public class DataAccessExceptionHandler {
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Object> exceptionHandler(DataAccessException e) {
        log.error(e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
