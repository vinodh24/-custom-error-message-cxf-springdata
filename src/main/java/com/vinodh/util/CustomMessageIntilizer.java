package com.vinodh.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vinodh.dto.Resource;
import com.vinodh.dto.ResourceBundle;

public class CustomMessageIntilizer{
     
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomMessageIntilizer.class.getName());

	
	private String resourceBundleLocation;
	
	@Autowired
	private XmlMapperUtil xmlMapperUtil;
    
    public static Map<String, Resource> resourceBundleMap = new HashMap<String, Resource>();
      
	public void init() throws Exception {
		loadXmlResourceBundle();			
	}
	
	private void loadXmlResourceBundle(){
		try {
			String xml = xmlMapperUtil.inputPutFileToXmlString(resourceBundleLocation);
			ResourceBundle resourceBundle = xmlMapperUtil.mapFromXml(xml, ResourceBundle.class);
			if(resourceBundle!=null){
				createErrorMessageMap(resourceBundle.getResource());
			}
		} catch (IOException e) {			
			LOGGER.error("Failed to process Error Resource Bundle file : ", e.getMessage(), e);
		}
	}
	
	private void createErrorMessageMap(List<Resource> resourceBundleList){
		resourceBundleMap = resourceBundleList.stream().collect(
                Collectors.toMap(Resource::getKey, resource -> resource));
	}

	public String getResourceBundleLocation() {
		return resourceBundleLocation;
	}

	public void setResourceBundleLocation(String resourceBundleLocation) {
		this.resourceBundleLocation = resourceBundleLocation;
	}

}
