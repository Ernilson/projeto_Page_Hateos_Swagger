package br.com.Ti.exceptions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHadler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request){
//		ExceptionResponse exceptionResponse = new ExceptionResponse("message", new Date(), null, ex.getMessage(), request.getDescription(false));
		ExceptionResponse response = new ExceptionResponse();
		response.setMessage(ex.getMessage());
		response.setTimestamp(new Date());
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setError("Erro ao processar sua requisição");
		response.setPath(request.getDescription(false));
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestException(Exception ex, HttpServletRequest request){
		ExceptionResponse ex1 = new ExceptionResponse();
		ex1.setTimestamp(new Date());
		ex1.setMessage(ex.getMessage());				
		ex1.setStatus(HttpStatus.BAD_REQUEST.value());
		ex1.setError("Erro ao processar sua requisição");
		ex1.setPath(request.getRequestURI());	
		
		return new ResponseEntity<>(ex1, HttpStatus.BAD_REQUEST);
	}
	
}
