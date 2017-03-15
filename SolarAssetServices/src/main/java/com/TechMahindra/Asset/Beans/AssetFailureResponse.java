/**
 * @author SY00489214
 * 
 * Store asset creation failure message 
 */
package com.TechMahindra.Asset.Beans;

import org.springframework.stereotype.Service;

@Service
public class AssetFailureResponse {
	
	private String code;
	private String message;
	private String suggestion;
	private String requestId;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	
	
}
