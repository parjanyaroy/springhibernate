package com;

import java.io.IOException;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandlerMethods {
	
	// THis will be a global exception handler . Using this makes the job is by \
	// not requiring to handle exceptions individually in controllers 
	
	// Views that are returned on various exceptions can be configured in xml too.
	// In that case no java class will be required .
	
	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException(Exception e) {
		System.out.println("NullPointerException occured :" + e.getMessage().toString());
		return "NullPointerException"; // Returns the name of the JSP of the
										// error page
	}
	
	
	@ExceptionHandler(value = IOException.class)
	public String handleIOException(Exception e) {
		System.out.println("IOException occured :" + e.getMessage().toString());
		return "IOException"; // Returns the name of the JSP of the
										// error page
	}
}
