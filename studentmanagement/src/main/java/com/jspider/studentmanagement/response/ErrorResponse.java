package com.jspider.studentmanagement.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse {

	 private String exceptionName;  // Field for the exception class name
	    private String message;
	   

	    public ErrorResponse(Exception exception, String message ) {
	      
	        this.message = message;
	        this.exceptionName = exception.getClass().getSimpleName(); // Get the exception class name
	    }
}
