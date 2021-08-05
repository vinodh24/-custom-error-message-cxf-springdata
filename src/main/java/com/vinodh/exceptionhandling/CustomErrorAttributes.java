package com.vinodh.exceptionhandling;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import com.vinodh.dto.Resource;
import com.vinodh.util.CustomMessageIntilizer;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {	
		Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
		Object timestamp = errorAttributes.get("timestamp");
		if (timestamp == null) {
			errorAttributes.put("timestamp", dateFormat.format(new Date()));
		} else {
			errorAttributes.put("timestamp", dateFormat.format((Date) timestamp));
		}
		System.out.println(errorAttributes+"   ::::errorAttributes");
		//webRequest.getHeaderNames().forEachRemaining(System.out::println);
		return getErrorResource(errorAttributes);
	}
	
	public static Map<String, Object> getErrorResource(Map<String, Object> errorAttributes){
		Resource errorMessage = null;
		Map<String, Object> customErrors = new HashMap<String, Object>();
		for (Entry<String, Resource> entry : CustomMessageIntilizer.resourceBundleMap.entrySet()) {
			if(errorAttributes.get("message")!=null)
			if(errorAttributes.get("message").toString().contains(entry.getKey())){
				errorMessage = entry.getValue();
				break;
			}
		}
		
		if(null != errorMessage){
			customErrors.put("responseCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
			customErrors.put("responseMessage", errorMessage.getValue());
			customErrors.put("errorCode", errorMessage.getId());
			customErrors.put("requestURI", errorAttributes.get("path"));
			customErrors.put("timestamp", errorAttributes.get("timestamp"));
			return customErrors;
		}else{
			return getErrorResponse(errorAttributes);
		}
	}
	
	public static Map<String, Object> getErrorResponse(Map<String, Object> errorAttributes){
		Map<String, Object> customErrors = new HashMap<String, Object>();
		customErrors.put("responseCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
		customErrors.put("responseCode", errorAttributes.get("status"));
		customErrors.put("responseMessage", errorAttributes.get("message"));
		customErrors.put("requestURI", errorAttributes.get("path"));
		customErrors.put("timestamp", errorAttributes.get("timestamp"));
		errorAttributes=null;
		return customErrors;		
	}
	
	/*@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {	
		Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
		Object timestamp = errorAttributes.get("timestamp");
		if (timestamp == null) {
			errorAttributes.put("timestamp", dateFormat.format(new Date()));
		} else {
			errorAttributes.put("timestamp", dateFormat.format((Date) timestamp));
		}
		System.out.println(errorAttributes+"   ::::errorAttributes");

		return errorAttributes;
	}*/
	

}
