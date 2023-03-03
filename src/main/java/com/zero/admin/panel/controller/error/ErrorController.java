package com.zero.admin.panel.controller.error;

import com.zero.admin.panel.dto.response.ABaseResponse;
import com.zero.admin.panel.error.InternalServerException;
import com.zero.admin.panel.error.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<?> internalServerErrorException(InternalServerException e){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ABaseResponse(500, e.getMessage()));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ABaseResponse(404, e.getMessage()));
    }
}
