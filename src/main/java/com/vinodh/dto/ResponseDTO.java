package com.vinodh.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({ "responseCode", "timestamp", "errorCode", "requestURI", "responseMessage" })
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
setterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE,
isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class ResponseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
    
	private int responseCode;
	private String timestamp;
	private String responseMessage;
	private String errorCode;
	private String requestURI;

	public ResponseDTO() {
		
	}
	
	
	public ResponseDTO(String timestamp, String message, String requestURI) {
		super();
		this.timestamp = timestamp;
		this.responseMessage = message;
		this.requestURI = requestURI;
	}

	public ResponseDTO(String timestamp, String message, String requestURI,String errorCode) {
		super();
		this.timestamp = timestamp;
		this.responseMessage = message;
		this.requestURI = requestURI;
		this.errorCode = errorCode;
	}

	public ResponseDTO(String timestamp, String message, String requestURI,String errorCode,int responseCode) {
		super();
		this.timestamp = timestamp;
		this.responseMessage = message;
		this.requestURI = requestURI;
		this.errorCode = errorCode;
		this.responseCode = responseCode;
	}

	public String getRequestURI() {
		return requestURI;
	}
	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}
	public String getTimstap() {
		return timestamp;
	}
	public void setTimstap(String timstap) {
		this.timestamp = timstap;
	}

	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}
