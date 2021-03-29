/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author dfch1
 */
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ExceptionConfig> handleNotFoundException(UserNotFoundException ex, WebRequest request) {
        ExceptionConfig exceptionResponse = new ExceptionConfig(new Date(), ex.getMessage(),
                request.getDescription(false), HttpStatus.NOT_FOUND.getReasonPhrase());
        return new ResponseEntity<ExceptionConfig>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(InvalidUserException.class)
    public final ResponseEntity<ExceptionConfig> handleInvalidUserdException(InvalidUserException ex, WebRequest request) {
        ExceptionConfig exceptionResponse = new ExceptionConfig(new Date(), ex.getMessage(),
                request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return new ResponseEntity<ExceptionConfig>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ExceptionConfig> handleBadRequestException(BadRequestException ex, WebRequest request) {
        ExceptionConfig exceptionResponse = new ExceptionConfig(new Date(), ex.getMessage(),
                request.getDescription(false), HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<ExceptionConfig>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
