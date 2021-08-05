package com.vinodh.dto;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "resourcebundle")
public class ResourceBundle {
	
	@JacksonXmlProperty
	private List<Resource> resource;

	public List<Resource> getResource() {
		return resource;
	}

	@Override
	public String toString() {
		return "Resourcebundle [resource=" + resource + "]";
	}

	public void setResource(List<Resource> resource) {
		this.resource = resource;
	}


}
