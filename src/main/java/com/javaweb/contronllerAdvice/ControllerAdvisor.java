package com.javaweb.contronllerAdvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.model.erroResponDTO;

import customexceptions.FieldRequiredException;
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Object> athermathticException(
            ArithmeticException ex,  WebRequest request) {
    		
    	erroResponDTO error = new erroResponDTO();
    	error.setError(ex.getMessage());
    	List<String> details = new ArrayList<String>();
    	details.add("làm sao chia được cho số không");
    	error.setDetail(details);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    
    @ExceptionHandler(FieldRequiredException.class)
    public ResponseEntity<Object> FieldRequiredException(
    	FieldRequiredException ex,  WebRequest request) {
    	erroResponDTO error = new erroResponDTO();
		error.setError(ex.getMessage());
		List<String> detail = new ArrayList<>();
		detail.add("check laij name hoac getNumberOfbasement di boi vi bi null do");
		error.setDetail(detail);
    	
        return new ResponseEntity<>(error, HttpStatus.BAD_GATEWAY);
    }
}

