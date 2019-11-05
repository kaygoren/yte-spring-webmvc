package yte.spring.webmvc.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {IllegalArgumentException.class})
	public ResponseEntity handleIllegalArgumentException(
			RuntimeException ex, WebRequest webRequest) {
		return handleExceptionInternal(ex,"Yollanan Istek Hatalı!",
				null, HttpStatus.BAD_REQUEST, webRequest);
	}
}
