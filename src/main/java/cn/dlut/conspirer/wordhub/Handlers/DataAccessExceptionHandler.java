// SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package cn.dlut.conspirer.wordhub.Handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 处理数据库访问错误
 *
 * @author OuOu
 * @version 1.0
 */
@RestControllerAdvice
@Slf4j
public class DataAccessExceptionHandler {
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Object> exceptionHandler(DataAccessException e) {
        log.error("DataAccessException: " + e.getMessage());
        return ResponseEntity.internalServerError().body("后端数据库读取错误");
    }
}
