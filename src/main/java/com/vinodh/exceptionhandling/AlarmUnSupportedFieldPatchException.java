package com.vinodh.exceptionhandling;


public class AlarmUnSupportedFieldPatchException extends RuntimeException {

	private static final long serialVersionUID = -3240840821998357447L;

	public AlarmUnSupportedFieldPatchException(String keys) {
		super("Field " + keys.toString() + " update is not allow.");
	}

}