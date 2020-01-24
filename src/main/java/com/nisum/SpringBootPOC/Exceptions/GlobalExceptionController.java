package com.nisum.SpringBootPOC.Exceptions;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.nisum.SpringBootPOC.model.Student;
@ControllerAdvice
@RestController
public class GlobalExceptionController {
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<?> handlestudentNotFoundException(StudentNotFoundException exception) {
		//ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(),
		       // request.getDescription(false));
		  //return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	      return new ResponseEntity<>("student not found", HttpStatus.NOT_FOUND);

	}

}
