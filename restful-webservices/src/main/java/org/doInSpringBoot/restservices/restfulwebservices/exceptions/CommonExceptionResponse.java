package org.doInSpringBoot.restservices.restfulwebservices.exceptions;

import java.util.Date;

public class CommonExceptionResponse {
	
	private Date timeOfException;
	private String message;
	private String details;
	
	public CommonExceptionResponse() {	}

	public CommonExceptionResponse(Date timeOfException, String message, String details) {
		super();
		this.timeOfException = timeOfException;
		this.message = message;
		this.details = details;
	}

	public Date getTimeOfException() {
		return timeOfException;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
}
