package com.cake.manager.handler;


import com.cake.manager.exception.EmployeeDataNotFoundException;
import com.cake.manager.exception.EmployeeInsertionFailureException;
import com.cake.manager.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(EmployeeDataNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleDataNotFoundException(EmployeeDataNotFoundException e){
        ApiResponse<String> response = ApiResponse.<String>builder().resultDesc("Error").errors(e.getLocalizedMessage()).build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeInsertionFailureException.class)
    public ResponseEntity<ApiResponse<String>> handleCreationException(EmployeeInsertionFailureException e){
        ApiResponse<String> response = ApiResponse.<String>builder().resultDesc("Error").errors(e.getLocalizedMessage()).build();
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
