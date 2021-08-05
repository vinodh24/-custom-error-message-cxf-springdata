package com.vinodh.exceptionhandling;

import java.io.IOException;
import java.sql.SQLSyntaxErrorException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.SQLGrammarException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vinodh.dto.Resource;
import com.vinodh.dto.ResponseDTO;
import com.vinodh.util.CustomMessageIntilizer;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler{

	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@ExceptionHandler(AlarmNotFoundException.class)
	public ResponseEntity<ResponseDTO> springHandleNotFound(AlarmNotFoundException anfe,HttpServletResponse response,final WebRequest webRequest,final HttpServletRequest request) throws IOException {
		System.out.println("AlarmNotFoundException     Block");
		return getErrorResource(HttpStatus.NOT_FOUND, anfe.getMessage(), request);
	}

	@ExceptionHandler({AlarmUnSupportedFieldPatchException.class})
	public ResponseEntity<ResponseDTO> springUnSupportedFieldPatch(AlarmUnSupportedFieldPatchException anfe,HttpServletResponse response,final WebRequest webRequest,final HttpServletRequest request) throws IOException {		
		System.out.println("AlarmUnSupportedFieldPatchException     Block");
		return getErrorResource(HttpStatus.BAD_REQUEST, anfe.getMessage(), request);
	}
	
	@ExceptionHandler({SQLGrammarException.class,InvalidDataAccessResourceUsageException.class,SQLSyntaxErrorException.class})
	public ResponseEntity<ResponseDTO> unknown(Exception anfe,HttpServletResponse response,final WebRequest webRequest,final HttpServletRequest request) throws IOException {		
		//Map<String, Object> errorAttributes =new DefaultErrorAttributes().getErrorAttributes(webRequest, true);		
		System.out.println("    unknown     Block"+anfe.getMessage());
		return getErrorResource(HttpStatus.BAD_REQUEST, anfe.getMessage(), request);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDTO> generationExceptionHandler(Exception ex,HttpServletResponse response,final WebRequest webRequest,final HttpServletRequest request) throws IOException{				
		System.out.println("Exception     Block");
		return getErrorResource(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
	}


	public static ResponseEntity<ResponseDTO> getErrorResource(HttpStatus internalServerError, String message,HttpServletRequest request){
		Resource errorMessage = null;
		ResponseDTO response = new ResponseDTO();
		for (Entry<String, Resource> entry : CustomMessageIntilizer.resourceBundleMap.entrySet()) {
			if(message.contains(entry.getKey())){
				errorMessage = entry.getValue();
				break;
			}
		}

		if(null != errorMessage){
			response.setErrorCode(errorMessage.getId());
			response.setResponseMessage(errorMessage.getValue());
			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setTimstap(dateFormat.format(new Date()));
			response.setRequestURI(request.getRequestURI());
			return new ResponseEntity<ResponseDTO>(response,internalServerError);
		}else{
			return getErrorResponse(internalServerError,message,request);
		}
	}

	public static ResponseEntity<ResponseDTO> getErrorResponse(HttpStatus internalServerError, String message, HttpServletRequest request){
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setResponseCode(internalServerError.value());
		responseDTO.setTimstap(dateFormat.format(new Date()));
		responseDTO.setResponseMessage(message);
		responseDTO.setErrorCode(internalServerError+"");
		responseDTO.setRequestURI(request.getRequestURI());				
		return new ResponseEntity<ResponseDTO>(responseDTO,internalServerError);		
	}

}
