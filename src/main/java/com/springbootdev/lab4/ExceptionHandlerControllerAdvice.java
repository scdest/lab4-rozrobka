package com.springbootdev.lab4;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

        @ExceptionHandler(IOException.class)
        public ResponseEntity<ApiError> handleIOException(IOException ex) {
            ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @ExceptionHandler(SQLException.class)
        public ResponseEntity<ApiError> handleSQLException(SQLException ex) {
            ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @ExceptionHandler(ParseException.class)
        public ResponseEntity<ApiError> handleParseException(ParseException ex) {
            ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
            return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(RuntimeException.class)
        public ResponseEntity<ApiError> handleRuntimeException(RuntimeException ex) {
            ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @ExceptionHandler(IndexOutOfBoundsException.class)
        public ResponseEntity<ApiError> handleIndexOutOfBoundsException(IndexOutOfBoundsException ex) {
            ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
            return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<ApiError> handleException(Exception ex) {
            ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
            return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
