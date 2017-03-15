/**
 * @author SY00489214
 * 
 * DAO Implementation class of Solar Asset Services
 */
package com.TechMahindra.Asset.DAO;

//import org.slf4j.logger;
//import org.slf4j.loggerFactory;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.TechMahindra.Asset.Beans.AssetFailureResponse;
import com.TechMahindra.Asset.Beans.Response;
import com.TechMahindra.Asset.Beans.WetherData;
import com.TechMahindra.Asset.Properties.AssetProperties;
import com.TechMahindra.Asset.Properties.ServiceProperties;
import com.TechMahindra.Asset.Utils.PredixAssetUtils;
import com.TechMahindra.Asset.Utils.TokenUtil;

@Service
@ComponentScan("com.TechMahindra")
public class PredixAssetDAOImpl implements PredixAssetDAO {

	//private final logger logger = loggerFactory.getlogger(this.getClass());
	
	@Autowired
	private TokenUtil tokenUtil;
	
	@Autowired
	private Response response;
	
	@Autowired
	private AssetFailureResponse failureResponse;
	
	@Autowired
	private AssetProperties assetProperties;
	
	@Autowired
	private PredixAssetUtils assetUtil;
	
	@Autowired
	private ServiceProperties properties;
	
	public Response createAsset(String classificatonName,String asset_details){
		//logger.info(this.getClass().getName()+" - createAsset/");
		HttpHeaders headers = assetUtil.createHeaders();
		HttpEntity<String> request = new HttpEntity<String>(asset_details,headers);
		return postDataToPredixCloud(classificatonName,assetProperties.getAssetUri(),request);
	}
	
	@Override
	public Response getAssetModels(String classificationName) {
		//logger.info(this.getClass().getName()+" - getAssetModels/");
		HttpHeaders headers = assetUtil.createHeaders();
		HttpEntity<String> request = new HttpEntity<String>(headers);
		return getDataFromPredixCloud(classificationName,assetProperties.getAssetUri()+"/"+classificationName,request);
	}
	
	@Override
	public Response getSpecificAssetModel(String classificationName,
			String assetName) {
		//logger.info(this.getClass().getName()+" - getSpecificAssetModel");
		HttpHeaders headers = assetUtil.createHeaders();
		HttpEntity<String> request = new HttpEntity<String>(headers);
		return getDataFromPredixCloud(classificationName,assetProperties.getAssetUri()+"/"+classificationName+"/"+assetName,request);
	}

	
	/*
	 * This method will interact with predix cloud to create classification
	 * 
	 * (non-Javadoc)
	 * @see com.TechMahindra.Asset.DAO.PredixAssetDAO#createClassification(java.lang.String)
	 */
	@Override
	public Response createClassification(String classificationName,String asset_details) {
		//logger.info(this.getClass().getName()+" - createClassification/");
		HttpHeaders headers = assetUtil.createHeaders();
		HttpEntity<String> request = new HttpEntity<String>(asset_details,headers);
		return postDataToPredixCloud(classificationName,assetProperties.getAssetUri(),request);
	}

	

	@Override
	public Response getClassifications(String classificationName,String pageSize) {
		//logger.info(this.getClass().getName()+" - getClassifications/");
		HttpHeaders headers = assetUtil.createHeaders();
		HttpEntity<String> request = new HttpEntity<String>(headers);
		String url = assetProperties.getAssetUri()+"/"+classificationName;
		if(pageSize != null && !pageSize.trim().equals(""))
			url+="?pageSize="+pageSize;
		else
			url+="?pageSize=150";
		return getDataFromPredixCloud(classificationName,url,request);
	}


	@Override
	public Response getNamesInClassification(String classificationName) {
		//logger.info(this.getClass().getName()+" - getClassifications/");
		HttpHeaders headers = assetUtil.createHeaders();
		List<String> lstStrs = new ArrayList<String>();
		HttpEntity<String> request = new HttpEntity<String>(headers);
		//@SuppressWarnings("unchecked")
		@SuppressWarnings("unchecked")
		List<Object> lstVals = (List<Object>) getDataFromPredixCloud(classificationName,assetProperties.getAssetUri()+"/"+classificationName,request).getData();
		System.out.println(lstVals.size());
		for(Object obj : lstVals){
			LinkedHashMap<?, ?> hMap = (LinkedHashMap<?, ?>) obj;
			if(hMap != null && hMap.size() > 0)
				lstStrs.add((String) hMap.get("name"));
		}
		response.setData(lstStrs);
		return response;
	}

	@Override
	public Response getBlockClassificationNamesByLocation(String blockClassificatin, String locationName) {
		//logger.info(this.getClass().getName()+" - getBlockClassificationNamesByLocation/");
		HttpHeaders headers = assetUtil.createHeaders();
		List<String> lstStrs = new ArrayList<String>();
		HttpEntity<String> request = new HttpEntity<String>(headers);
		@SuppressWarnings("unchecked")
		List<Object> lstVals = (List<Object>) getDataFromPredixCloud(blockClassificatin,assetProperties.getAssetUri()+"/"+blockClassificatin+"?filter=parent=/Locations/"+locationName,request).getData();
		System.out.println(lstVals.size());
		for(Object obj : lstVals){
			LinkedHashMap<?, ?> hMap = (LinkedHashMap<?, ?>) obj;
			if(hMap != null && hMap.size() > 0)
				lstStrs.add((String) hMap.get("name"));
		}
		response.setData(lstStrs);
		return response;
	}

	@Override
	public Response getCBClassificationNamesByBlock(
			String cBClassificationName, String blockName) {
		//logger.info(this.getClass().getName()+" - getBlockClassificationNamesByLocation/");
		HttpHeaders headers = assetUtil.createHeaders();
		List<String> lstStrs = new ArrayList<String>();
		HttpEntity<String> request = new HttpEntity<String>(headers);
		@SuppressWarnings("unchecked")
		List<Object> lstVals = (List<Object>) getDataFromPredixCloud(cBClassificationName,assetProperties.getAssetUri()+"/"+cBClassificationName+"?filter=parent=/Blocks/"+blockName,request).getData();
		System.out.println(lstVals.size());
		for(Object obj : lstVals){
			LinkedHashMap<?, ?> hMap = (LinkedHashMap<?, ?>) obj;
			if(hMap != null && hMap.size() > 0){
				//if(!(Boolean)hMap.get("isDeleted")){
					lstStrs.add((String) hMap.get("name"));
				//}
			}
		}
		response.setData(lstStrs);
		return response;
	}
	
	@Override
	public Response getInverterNamesByCB(String invClassificationName,
			String cbName,boolean flag) {
		//logger.info(this.getClass().getName()+" - getBlockClassificationNamesByLocation/");
		HttpHeaders headers = assetUtil.createHeaders();
		List<String> lstStrs = new ArrayList<String>();
		HttpEntity<String> request = new HttpEntity<String>(headers);
		@SuppressWarnings("unchecked")
		List<Object> lstVals = (List<Object>) getDataFromPredixCloud(invClassificationName,assetProperties.getAssetUri()+"/"+invClassificationName+"?filter=parent=/CBS/"+cbName,request).getData();
		response.setData(lstVals);
		if(!flag){
		System.out.println(lstVals.size());
		for(Object obj : lstVals){
			LinkedHashMap<?, ?> hMap = (LinkedHashMap<?, ?>) obj;
			if(hMap != null && hMap.size() > 0){
				//if(!(Boolean)hMap.get("isDeleted"))
					lstStrs.add((String) hMap.get("name"));
					
			}
		}
		response.setData(lstStrs);
		}
		return response;
	}
	
	@Override
	public Response getInvertersByCB(String invClassificationName,
			String cbName) {
		//logger.info(this.getClass().getName()+" - getBlockClassificationNamesByLocation/");
		HttpHeaders headers = assetUtil.createHeaders();
		HttpEntity<String> request = new HttpEntity<String>(headers);
		@SuppressWarnings("unchecked")
		List<Object> lstVals = (List<Object>) getDataFromPredixCloud(invClassificationName,assetProperties.getAssetUri()+"/"+invClassificationName+"?filter=parent=/CBS/"+cbName,request).getData();
		System.out.println(lstVals.size());
		
		response.setData(lstVals);
		return response;
	}

	@Override
	public Response getPanelsByInverter(String panelClassificationName,
			String inverterName) {
		//logger.info(this.getClass().getName()+" - getBlockClassificationNamesByLocation/");
		HttpHeaders headers = assetUtil.createHeaders();
		List<String> lstStrs = new ArrayList<String>();
		HttpEntity<String> request = new HttpEntity<String>(headers);
		@SuppressWarnings("unchecked")
		List<Object> lstVals = (List<Object>) getDataFromPredixCloud(panelClassificationName,assetProperties.getAssetUri()+"/"+panelClassificationName+"?filter=parent=/Inverters/"+inverterName+"&pageSize=1000",request).getData();
		System.out.println(lstVals.size());
		for(Object obj : lstVals){
			LinkedHashMap<?, ?> hMap = (LinkedHashMap<?, ?>) obj;
			if(hMap != null && hMap.size() > 0)
				lstStrs.add((String) hMap.get("name"));
		}
		response.setData(lstVals);
		return response;
	}

	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Response getInvertersTimeSeriesTags(String location, String block,
			String cb) {
		//logger.info(this.getClass().getName()+" - getBlockClassificationNamesByLocation/");
		HttpHeaders headers = assetUtil.createHeaders();
		List<ArrayList> lstStrs = new ArrayList<ArrayList>();
		HttpEntity<String> request = new HttpEntity<String>(headers);
		List<Object> lstVals = (List<Object>) getDataFromPredixCloud(location,assetProperties.getAssetUri()+"/Inverters?filter=parent=/CBS/"+cb,request).getData();
		for(Object obj : lstVals){
			LinkedHashMap<?, ?> hMap = (LinkedHashMap<?, ?>) obj;
			if(hMap != null && hMap.size() > 0){
				List<Object> obj1 = (List<Object>) hMap.get("timeSeriesTags");
				ArrayList hMap1 = (ArrayList) obj1;
				lstStrs.add(hMap1);
			}
		}
		response.setData(lstStrs);
		return response;
	}

	
	@Override
	public Response getSpecificClassifications(String classificationName,
			String assetName) {
		//logger.info(this.getClass().getName()+" - getSpecificClassifications");
		HttpHeaders headers = assetUtil.createHeaders();
		HttpEntity<String> request = new HttpEntity<String>(headers);
		return getDataFromPredixCloud(classificationName,assetProperties.getAssetUri()+"/"+classificationName+"/"+assetName,request);
	}

	@Override
	public Response deleteClassification(String classification,
			String classificationName) {
		HttpHeaders headers = assetUtil.createHeaders();
		HttpEntity<String> request = new HttpEntity<String>(headers);
		return deleteDataFromPredixCloud(classification,assetProperties.getAssetUri()+"/"+classification+"/"+classificationName,request);
	}

	
	public Response postDataToPredixCloud(String classificationName,String assetUri,
			HttpEntity<String> request) {
		try{
		//logger.info(this.getClass().getName()+" - postDataToPredixCloud ");
		//logger.info("Calling Asset Services URI : " + assetUri+"/"+classificationName);
		RestTemplate restTemplate = new RestTemplate();
		Object obj = restTemplate.postForObject(assetUri+"/"+classificationName,request,Object.class);
		if(obj == null)
			return assetUtil.sendResponse(properties.getSuccessCode(), properties.getSuccessMsg(),"");
		else{
			AssetFailureResponse response = (AssetFailureResponse)obj;
			return assetUtil.sendResponse(response.getCode(), response.getMessage(),response.getSuggestion());
		}
		}
		catch(Exception exception){
			exception.printStackTrace();
			return assetUtil.sendResponse(assetProperties.getClsCreFailedCode(), assetProperties.getClsCreFailedMsg(),"");
		}
	}

	public Response getDataFromPredixCloud(String classificationName,String assetUri,
			HttpEntity<String> request) {
		//logger.info(this.getClass().getName()+" - getDataFromPredixCloud ");
		//logger.info("Calling Asset Services URI : " + assetUri);
		try{
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> response = restTemplate.exchange(assetUri, HttpMethod.GET,request,String.class);
		if(response != null && response.getBody() != null){
			/*JSONArray resArr = new JSONArray(response.getBody());
			for(int i=0;i<=resArr.length()-1;i++){
				JSONObject obj = (JSONObject) resArr.get(i);
				obj.put("action_items", "<div><paper-button raised onclick='edit.open()'>Edit</paper-button></div>");
			}*/
			return assetUtil.sendResponse(properties.getSuccessCode(), properties.getSuccessMsg(),response.getBody()+"");
		}else
			return assetUtil.sendResponse(properties.getNoDataToDispCode(), properties.getNoDataToDispMsg(),"");
		}
		catch(HttpClientErrorException exception){
			exception.printStackTrace();
				return assetUtil.sendResponse(properties.getClsNotAvailableCode(), properties.getClsNotAvailableMsg(),"");
		}catch(Exception e){
			e.printStackTrace();
			return assetUtil.sendResponse(properties.getExceptionCode(), properties.getExceptionMsg(),"");
		}
	}

	
	public Response deleteDataFromPredixCloud(String classification,
			String uri, HttpEntity<String> request) {
		//logger.info(this.getClass().getName()+" - deleteDataFromPredixCloud ");
		//logger.info("Calling Asset Services URI : " + uri);
		try{
		System.out.println(uri);
		RestTemplate restTemplate = new RestTemplate();
		//HttpEntity<String> response = restTemplate.exchange(uri, HttpMethod.DELETE,request,String.class);
//		if(!response.hasBody())
			restTemplate.exchange(uri, HttpMethod.DELETE,request,String.class);
			return assetUtil.sendResponse(properties.getSuccessCode(), properties.getSuccessMsg(),"");
		/*else
			return assetUtil.sendResponseStr(properties.getNoDataToDispCode(), properties.getNoDataToDispMsg());*/
		}
		catch(HttpClientErrorException exception){
				return assetUtil.sendResponse(properties.getAssetNotAvailableCode(), properties.getAssetNotAvailableMsg(),"");
		}catch(Exception e){
			return assetUtil.sendResponse(properties.getExceptionCode(), properties.getExceptionMsg(),"");
		}
	}

	@Override
	public Response getAssetNames(String assetName) {
		//logger.info(this.getClass().getName()+" - getAssetModels/");
		HttpHeaders headers = assetUtil.createHeaders();
		HttpEntity<String> request = new HttpEntity<String>(headers);
		Response response =  getDataFromPredixCloud(assetName,assetProperties.getAssetUri()+"/"+assetName,request);
		List<String> names = new ArrayList<String>();
		try {
			@SuppressWarnings("unchecked")
			List<Object> lstObjs = (List<Object>) response.getData();
			for(Object obj :  lstObjs){
				@SuppressWarnings("rawtypes")
				java.util.LinkedHashMap map =  (LinkedHashMap) obj;
				System.out.println(map.get("name"));
				if(!(Boolean)map.get("isDeleted"))
					names.add((String) map.get("name"));
			}
			response.setData(names);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Response getWetherInfo() {
		HttpHeaders headers = assetUtil.createHeaders();
		HttpEntity<String> request = new HttpEntity<String>("");
		RestTemplate restTemplate = new RestTemplate();
		//HttpEntity<String> response = restTemplate.exchange("http://api.openweathermap.org/data/2.5/weather?lat=17.571171&lon=78.436106&appid=6b4fec3cfeb666ed226daff42cb09a95", HttpMethod.GET,request,String.class);
		String result = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?lat=17.571171&lon=78.436106&appid=6b4fec3cfeb666ed226daff42cb09a95", String.class);
		//System.out.println(result);
		JSONObject json = null;
		try {
			/*json = new JSONObject(result);
			WetherData wData = new WetherData();
			JSONObject tempObj  =  (JSONObject) json.get("main");
			double temp = ((double) tempObj.get("temp"))-273;
			wData.setTemperature(temp+"");
			wData.setHumidity(tempObj.get("humidity")+"");
			JSONObject windObj  =  (JSONObject) json.get("wind");
			wData.setWind(windObj.getString("speed")+"");
			
			JSONObject cloudsObj  =  (JSONObject) json.get("clouds");
			System.out.println(cloudsObj);
			wData.setClouds(cloudsObj.getString("all")+"");*/
			return assetUtil.sendResponse(properties.getSuccessCode(), properties.getSuccessMsg(),result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return assetUtil.sendResponse(properties.getExceptionCode(), properties.getExceptionMsg(),"Something went wrong!");
		}
	}

	
	
	
	

}
