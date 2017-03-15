/**
 * @author SY00489214
 * 
 * Response class for all service calls
 */
package com.TechMahindra.Asset.Beans;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class Response implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String responceCode;
	private String responseMessage;
	public Object data;
	
	

	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getResponceCode() {
		return responceCode;
	}
	public void setResponceCode(String responceCode) {
		this.responceCode = responceCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	public String toString(){
		return "{responceCode : "+responceCode +",responseMessage : "+responseMessage+"}";
	}
}
