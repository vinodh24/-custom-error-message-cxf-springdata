package com.vinodh.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "resource")
public class Resource {

	private String id;
	@JacksonXmlElementWrapper(localName = "error-type")
	private String error_type;
	private String value;
	private String key;
	
	public String getId() {
		return id;
	}
	public String getError_type() {
		return error_type;
	}
	public String getValue() {
		return value;
	}
	public String getKey() {
		return key;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setError_type(String error_type) {
		this.error_type = error_type;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public void setKey(String key) {
		this.key = key;
	}
	@Override
	public String toString() {
		return "Resource [id=" + id + ", error_type=" + error_type + ", value="
				+ value + ", key=" + key + "]";
	}
}
