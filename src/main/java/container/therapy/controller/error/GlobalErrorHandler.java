/**
 * 
 */
package container.therapy.controller.error;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 */
@RestControllerAdvice
public class GlobalErrorHandler {

	// * One way to handle an error
	// Handles when entity is not found
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementException ex) {
	    ErrorResponse errorResponse = new ErrorResponse(
	        LocalDateTime.now(), // Current timestamp
	        HttpStatus.NOT_FOUND.value(), // HTTP status code
	        "Not Found", // Error type
	        ex.getMessage() // Error message
	    );
	    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

		@Data
		@AllArgsConstructor
		public class ErrorResponse {
			private LocalDateTime timestamp;
			private int status;
			private String error;
			private String message;
		}
	
	// Another way to handle an error
	// Handles invalid arguments
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
	    return new ResponseEntity<>("Error: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	// Handling general exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGeneralException(Exception ex) {
		return new ResponseEntity<>("An unexpected error occured: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}


