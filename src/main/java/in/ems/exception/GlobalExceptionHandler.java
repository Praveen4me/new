package in.ems.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {

		Map<String, String> error = new HashMap<>();
		Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
		for (ConstraintViolation<?> violation : constraintViolations) {
			String fieldName = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			error.put(fieldName, message);
		}

		return new ResponseEntity<Map<String, String>>(error, HttpStatus.BAD_REQUEST);

	}

}
