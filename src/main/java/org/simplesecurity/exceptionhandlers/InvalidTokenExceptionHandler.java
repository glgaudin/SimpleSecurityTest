package org.simplesecurity.exceptionhandlers;

import org.apache.log4j.Logger;
import org.simplesecurity.security.exception.InvalidTokenException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * 
 * Handles the InvalidTokenException
 *
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class InvalidTokenExceptionHandler extends AbstractExceptionHandler {

	private final static Logger logger = Logger.getLogger(InvalidTokenException.class);
	
    @ExceptionHandler(value = { InvalidTokenException.class })
    protected ResponseEntity<?> handleConflict(Exception ex, WebRequest request) {
    	logger.error(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(ERROR_PREFIX + ex.getMessage()) ,HttpStatus.FORBIDDEN);
    }

}
