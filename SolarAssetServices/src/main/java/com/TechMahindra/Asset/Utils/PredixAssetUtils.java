/**
 * @author SY00489214
 * 
 */
package com.TechMahindra.Asset.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.TechMahindra.Asset.Beans.Response;
import com.TechMahindra.Asset.Properties.AssetProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PredixAssetUtils {

	//private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Response response;
	
	@Autowired
	private TokenUtil tokenUtil;
	
	@Autowired
	private AssetProperties assetProperties;
	
	public String checkStringValid(String asset_details){
		if(asset_details == null || asset_details.trim().equals(""))
			return null;
		else{
			if(asset_details.startsWith("[") && asset_details.endsWith("]"))
				return asset_details;
			else return "["+asset_details+"]";
		}
	}
	
	public Response sendResponse(String noDataCode, String noDataMsg,String data) {
		
		response.setResponceCode(noDataCode);
		response.setResponseMessage(noDataMsg);
		if(data != null && !data.trim().equals(""))
			response.setData(getData(data));
		else
			response.setData("");
		return response;
	}
	
	private Object getData(String data) {
		 ObjectMapper mapper = new ObjectMapper();
		 try{
			return mapper.readValue(data.toString(), Object.class);
		 }catch(Exception e){
			 e.printStackTrace();
			 return null;
		 }
	}

	public String sendResponseStr(String noDataCode, String noDataMsg) {
		response.setResponceCode(noDataCode);
		response.setResponseMessage(noDataMsg);
		return response.toString();
	}
	
	public HttpHeaders createHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add(assetProperties.getHeaderAuthKey(), assetProperties.getHeaderAuthBearer()+" "+tokenUtil.getToken());
		headers.add(assetProperties.getContentType(), assetProperties.getContentTypeAj());
		headers.add(assetProperties.getPredixZoneIDKey(),assetProperties.getPredixZoneId());
		return headers;
	}
}
