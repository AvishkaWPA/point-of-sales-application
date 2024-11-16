package com.example.point_of_sale.advisor;

import com.example.point_of_sale.exception.NotFoundException;
import com.example.point_of_sale.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardResponse> handleException(Exception e){
        return new ResponseEntity<StandardResponse>(new StandardResponse(500,"Error",e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e){
        return new ResponseEntity<StandardResponse>(new StandardResponse(404,"Error",e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
