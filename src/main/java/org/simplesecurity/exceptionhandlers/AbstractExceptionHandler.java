package org.simplesecurity.exceptionhandlers;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Abstract exception handler that encapsulated the error response object
 * 
 */
public abstract class AbstractExceptionHandler extends ResponseEntityExceptionHandler {

	public static final String ERROR_PREFIX = "Error: ";
	
	public class ErrorResponse {

		private String errorMessage;

		public ErrorResponse(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}
		
	}
}
