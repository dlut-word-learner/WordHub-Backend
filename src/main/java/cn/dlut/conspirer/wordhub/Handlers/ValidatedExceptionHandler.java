// SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package cn.dlut.conspirer.wordhub.Handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 负责Controller方法参数校验异常处理的全局异常处理类
 *
 * @author OuOu
 * @version 1.0
 */
@Slf4j
@RestControllerAdvice
public class ValidatedExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> exceptionHandler(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        log.info(result.getTarget().toString());
        StringBuilder stringBuilder = new StringBuilder();
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            errors.forEach(p -> {
                FieldError fieldError = (FieldError) p;
                log.warn("Bad Request Parameters: VO Entity [{}], field [{}], value [{}],message [{}]", fieldError.getObjectName(), fieldError.getField(), fieldError.getRejectedValue().toString(), fieldError.getDefaultMessage());
                stringBuilder.append(fieldError.getDefaultMessage()).append("; ");
            });
        } else stringBuilder.append("未知错误");
        return ResponseEntity.badRequest().body(stringBuilder.toString());
    }
}
