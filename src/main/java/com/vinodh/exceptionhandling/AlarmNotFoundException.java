package com.vinodh.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlarmNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 509351511637285833L;

	public AlarmNotFoundException(Long id) {
        super("Alarm id not found : " + id);
    }
	
	public AlarmNotFoundException() {
        super("Alarm id not found : ");
    }

}
