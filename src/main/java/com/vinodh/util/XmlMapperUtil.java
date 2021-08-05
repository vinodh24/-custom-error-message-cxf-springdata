package com.vinodh.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlMapperUtil {
	
	@SuppressWarnings("deprecation")
	public  <T> T mapFromXml(String xml, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {
		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.setDefaultUseWrapper(false);
		return xmlMapper.readValue(xml, clazz);
	}
	
	@SuppressWarnings("deprecation")
	public  <T> String mapToXml(T obj) throws JsonProcessingException {
		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.setDefaultUseWrapper(false);
        return xmlMapper.writeValueAsString(obj);
    }
	public String inputPutFileToXmlString(String fileName) throws IOException {
		StringBuilder sb = new StringBuilder();
	    String line;
	    BufferedReader br = new BufferedReader(new FileReader(new ClassPathResource(fileName).getFile()));
	    while ((line = br.readLine()) != null) {
	        sb.append(line);
	    }
	    br.close();
	    line=null;
	    return sb.toString();		
	}
	
}
