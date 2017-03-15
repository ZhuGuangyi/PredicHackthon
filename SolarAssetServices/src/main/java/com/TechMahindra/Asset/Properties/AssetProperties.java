/**
 * @author SY00489214+
 * 
 * It will store the all properties of asset properties file
 */
package com.TechMahindra.Asset.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:asset.properties")
public class AssetProperties {

	 @Value("${HEADER_AUTHERIZATION_KEY}")
	 private String headerAuthKey;
	 
	 @Value("${HEADER_AUTHERIZATION_TYPE_BEARER}")
	 private String headerAuthBearer;
	 
	 @Value("${HEADER_CONTENT_TYPE}")
	 private String contentType;
	 
	 @Value("${HEADER_CONTENT_TYPE_A_J}")
	 private String contentTypeAj;
	 
	 @Value("${HEADER_PREDIX_ZONE_ID_KEY}")
	 private String predixZoneIDKey;
	 
	 @Value("${HEADER_PREDIX_ASSET_ZONE_ID_VALUE}")
	 private String predixZoneId;
	 
	 @Value("${PREDIX_ASSET_URI}")
	 private String assetUri;
	 
	 @Value("${FAILED_TO_CREATE_CLASSIFICATION_CODE}")
	 private String clsCreFailedCode;
	 
	 @Value("${FAILED_TO_CREATE_CLASSIFICATION}")
	 private String clsCreFailedMsg;
	 
	 @Value("${EXCEPTION_CODE}")
	 private String exceptionCode;
	 
	 @Value("${EXCEPTION_MESSAGE}")
	 private String exceptionMsg;
	 
	 
	

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public String getClsCreFailedCode() {
		return clsCreFailedCode;
	}

	public void setClsCreFailedCode(String clsCreFailedCode) {
		this.clsCreFailedCode = clsCreFailedCode;
	}

	public String getClsCreFailedMsg() {
		return clsCreFailedMsg;
	}

	public void setClsCreFailedMsg(String clsCreFailedMsg) {
		this.clsCreFailedMsg = clsCreFailedMsg;
	}

	public String getHeaderAuthKey() {
		return headerAuthKey;
	}

	public void setHeaderAuthKey(String headerAuthKey) {
		this.headerAuthKey = headerAuthKey;
	}

	public String getHeaderAuthBearer() {
		return headerAuthBearer;
	}

	public void setHeaderAuthBearer(String headerAuthBearer) {
		this.headerAuthBearer = headerAuthBearer;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentTypeAj() {
		return contentTypeAj;
	}

	public void setContentTypeAj(String contentTypeAj) {
		this.contentTypeAj = contentTypeAj;
	}

	public String getPredixZoneIDKey() {
		return predixZoneIDKey;
	}

	public void setPredixZoneIDKey(String predixZoneIDKey) {
		this.predixZoneIDKey = predixZoneIDKey;
	}

	public String getPredixZoneId() {
		return predixZoneId;
	}

	public void setPredixZoneId(String predixZoneId) {
		this.predixZoneId = predixZoneId;
	}

	public String getAssetUri() {
		return assetUri;
	}

	public void setAssetUri(String assetUri) {
		this.assetUri = assetUri;
	}
	 
	 
}
