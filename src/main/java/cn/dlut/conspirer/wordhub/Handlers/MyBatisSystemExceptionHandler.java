package cn.dlut.conspirer.wordhub.Handlers;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
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
public class MyBatisSystemExceptionHandler {
    @ExceptionHandler(MyBatisSystemException.class)
    public ResponseEntity<String> exceptionHandler(MyBatisSystemException e) {
        log.error("mybatis error: " + e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
