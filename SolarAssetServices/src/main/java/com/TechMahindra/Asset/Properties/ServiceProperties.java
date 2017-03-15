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
@PropertySource("classpath:application.properties")
public class ServiceProperties {

	 @Value("${SUCCESS_CODE}")
	 private String successCode;
	 
	 @Value("${SUCCESS_MESSAGE}")
	 private String successMsg;
	 
	 @Value("${SERVER_EXCEPTION_CODE}")
	 private String serverExceptionCode;
	 
	 @Value("${SERVER_EXCEPTION_MESSSAGE}")
	 private String serverExMsg;
	 
	 @Value("${PATH_NOT_FOUND_CODE}")
	 private String pathNotFoundCode;
	 
	 @Value("${PATH_NOT_FOUND_MESSAGE}")
	 private String pathNotFoundMsg;
	 
	 @Value("${NO_DATA_CODE}")
	 private String noDataCode;
	 
	 @Value("${NO_DATA_MESSAGE}")
	 private String noDataMsg;

	 @Value("${CLASSIFICATION_REQUIRED_CODE}")
	 private String classificationReqCode;
	 
	 @Value("${CLASSIFICATION_REQUIRED_MSG}")
	 private String classificationReqMsg;
	 
	 @Value("${CLASSIFICATION_NAME_REQUIRED_CODE}")
	 private String clsNameReqCode;
	 
	 @Value("${CLASSIFICATION_NAME_REQUIRED_CODE}")
	 private String clsNameReqMsg;
	 
	 @Value("${NO_DATA_TO_DISP_CODE}")
	 private String noDataToDispCode;
	 
	 @Value("${NO_DATA_TO_DISP_MSG}")
	 private String NoDataToDispMsg;
	 
	 @Value("${ASSET_NOT_AVAILABLE_CODE}")
	 private String assetNotAvailableCode;
	 
	 @Value("${ASSET_NOT_AVAILABLE_MSG}")
	 private String assetNotAvailableMsg;
	 
	 @Value("${CLASSIFICATION_NOT_AVAILABLE_CODE}")
	 private String clsNotAvailableCode;
	 
	 @Value("${CLASSIFICATION_NOT_AVAILABLE_MSG}")
	 private String clsNotAvailableMsg;
	 
	 @Value("${EXCEPTION_CODE}")
	 private String exceptionCode;
	 
	 @Value("${EXCEPTION_MESSAGE}")
	 private String exceptionMsg;
	 
	 @Value("${ASSET_NAME_REQUIRED_CODE}")
	 private String assetReqCode;
	 
	 @Value("${ASSET_NAME_REQUIRED_MSG}")
	 private String assetReqMsg;
	 
	 
	public String getAssetReqCode() {
		return assetReqCode;
	}

	public void setAssetReqCode(String assetReqCode) {
		this.assetReqCode = assetReqCode;
	}

	public String getAssetReqMsg() {
		return assetReqMsg;
	}

	public void setAssetReqMsg(String assetReqMsg) {
		this.assetReqMsg = assetReqMsg;
	}

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

	public String getAssetNotAvailableCode() {
		return assetNotAvailableCode;
	}

	public void setAssetNotAvailableCode(String assetNotAvailableCode) {
		this.assetNotAvailableCode = assetNotAvailableCode;
	}

	public String getAssetNotAvailableMsg() {
		return assetNotAvailableMsg;
	}

	public void setAssetNotAvailableMsg(String assetNotAvailableMsg) {
		this.assetNotAvailableMsg = assetNotAvailableMsg;
	}

	public String getClsNotAvailableCode() {
		return clsNotAvailableCode;
	}

	public void setClsNotAvailableCode(String clsNotAvailableCode) {
		this.clsNotAvailableCode = clsNotAvailableCode;
	}

	public String getClsNotAvailableMsg() {
		return clsNotAvailableMsg;
	}

	public void setClsNotAvailableMsg(String clsNotAvailableMsg) {
		this.clsNotAvailableMsg = clsNotAvailableMsg;
	}
	public String getNoDataToDispCode() {
		return noDataToDispCode;
	}

	public void setNoDataToDispCode(String noDataToDispCode) {
		this.noDataToDispCode = noDataToDispCode;
	}

	public String getNoDataToDispMsg() {
		return NoDataToDispMsg;
	}

	public void setNoDataToDispMsg(String noDataToDispMsg) {
		NoDataToDispMsg = noDataToDispMsg;
	}

	public String getClsNameReqCode() {
		return clsNameReqCode;
	}

	public void setClsNameReqCode(String clsNameReqCode) {
		this.clsNameReqCode = clsNameReqCode;
	}

	public String getClsNameReqMsg() {
		return clsNameReqMsg;
	}

	public void setClsNameReqMsg(String clsNameReqMsg) {
		this.clsNameReqMsg = clsNameReqMsg;
	}

	public String getSuccessCode() {
		return successCode;
	}

	public void setSuccessCode(String successCode) {
		this.successCode = successCode;
	}

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}

	public String getServerExceptionCode() {
		return serverExceptionCode;
	}

	public void setServerExceptionCode(String serverExceptionCode) {
		this.serverExceptionCode = serverExceptionCode;
	}

	public String getServerExMsg() {
		return serverExMsg;
	}

	public void setServerExMsg(String serverExMsg) {
		this.serverExMsg = serverExMsg;
	}

	public String getPathNotFoundCode() {
		return pathNotFoundCode;
	}

	public void setPathNotFoundCode(String pathNotFoundCode) {
		this.pathNotFoundCode = pathNotFoundCode;
	}

	public String getPathNotFoundMsg() {
		return pathNotFoundMsg;
	}

	public void setPathNotFoundMsg(String pathNotFoundMsg) {
		this.pathNotFoundMsg = pathNotFoundMsg;
	}

	public String getNoDataCode() {
		return noDataCode;
	}

	public void setNoDataCode(String noDataCode) {
		this.noDataCode = noDataCode;
	}

	public String getNoDataMsg() {
		return noDataMsg;
	}

	public void setNoDataMsg(String noDataMsg) {
		this.noDataMsg = noDataMsg;
	}

	public String getClassificationReqCode() {
		return classificationReqCode;
	}

	public void setClassificationReqCode(String classificationReqCode) {
		this.classificationReqCode = classificationReqCode;
	}

	public String getClassificationReqMsg() {
		return classificationReqMsg;
	}

	public void setClassificationReqMsg(String classificationReqMsg) {
		this.classificationReqMsg = classificationReqMsg;
	}
	 

	 
	
	 
	 
}
