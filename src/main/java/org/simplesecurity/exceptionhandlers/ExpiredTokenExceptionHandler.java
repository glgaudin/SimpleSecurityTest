package org.simplesecurity.exceptionhandlers;

import org.apache.log4j.Logger;
import org.simplesecurity.security.exception.ExpiredTokenException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * 
 * Handles the ExpiredTokenException
 *
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExpiredTokenExceptionHandler extends AbstractExceptionHandler {
	
	private final static Logger logger = Logger.getLogger(ExpiredTokenExceptionHandler.class);
	
    @ExceptionHandler(value = { ExpiredTokenException.class })
    protected ResponseEntity<?> handleConflict(Exception ex, WebRequest request) {
    	logger.error(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(ERROR_PREFIX + ex.getMessage()) ,HttpStatus.FORBIDDEN);
    }

}
