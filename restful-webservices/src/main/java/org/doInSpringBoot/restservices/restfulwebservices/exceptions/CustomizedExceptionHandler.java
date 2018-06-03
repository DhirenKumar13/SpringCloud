package org.doInSpringBoot.restservices.restfulwebservices.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

	public CustomizedExceptionHandler() {}
	
	/**
	 * 
	 * @param ex
	 * @param request
	 * @return
	 * @throws Exception
	 * 
	 * {
    		"timeOfException": "2018-05-28T21:05:40.648+0000",
    		"message": "id-9",
    		"details": "uri=/user/9"
	   }
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(
			Exception ex, WebRequest request) {
		
		CommonExceptionResponse response = new CommonExceptionResponse(new Date(),
				ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
		
	}
	
	/**
	 * 
	 * @param ex
	 * @param request
	 * @return
	 * 
	 * {
    		"timeOfException": "2018-05-28T21:08:54.102+0000",
    		"message": "id-9",
    		"details": "uri=/user/9"
	   }
	 */
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleAllUserNotFoundExceptionExceptions(
			UserNotFoundException ex, WebRequest request){
		
		CommonExceptionResponse response = new CommonExceptionResponse(new Date(),
				ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		
	}
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		CommonExceptionResponse response = new CommonExceptionResponse(
				new Date(),"Validation Failed",ex.getBindingResult().toString());
		
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}

}
