package cn.dlut.conspirer.wordhub.Handlers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author OuOu
 * @version 1.0
 */
@Slf4j
@RestControllerAdvice
public class JacksonExceptionHandler {
    @ExceptionHandler(JacksonException.class)
    ResponseEntity<String> jacksonExceptionHandler(JsonProcessingException e) {
        log.error("json相关错误: " + e.getMessage());
        return ResponseEntity.internalServerError().body("后端json处理错误");
    }
}
