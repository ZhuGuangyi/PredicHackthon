/**
 * @author SY00489214
 * 
 */
package com.TechMahindra.Asset.Services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.TechMahindra.Asset.Beans.Response;
import com.TechMahindra.Asset.DAO.PredixAssetDAO;
import com.TechMahindra.Asset.Properties.ServiceProperties;
import com.TechMahindra.Asset.Utils.PredixAssetUtils;

@Service
@ComponentScan("com.TechMahindra")
public class PredixAssetServicesImpl implements PredixAssetServices{

	Map<String,String> testMap = new HashMap<String,String>();
	//private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PredixAssetUtils assetUtil; 
	
	@Autowired
	private PredixAssetDAO assetDao;
	
	@Autowired
	private ServiceProperties properties;
	
	@Override
	public Response createAsset(String classificationName,String asset_details) {
		asset_details = assetUtil.checkStringValid(asset_details);
		if(classificationName == null || classificationName.trim().equals(""))
			return assetUtil.sendResponse(properties.getClsNameReqCode(),properties.getClsNameReqMsg(),"");
		else if(asset_details == null)
			return assetUtil.sendResponse(properties.getNoDataCode(),properties.getNoDataMsg(),"");
		else
			return assetDao.createAsset(classificationName,asset_details);
	}
	
	@Override
	public Response getAssetModels(String classificationName) {
		//logger.info(this.getClass().getName()+" - getAssetModels/"+ classificationName);
	 if(classificationName == null || classificationName.trim().equals(""))
		return assetUtil.sendResponse(properties.getAssetReqCode(),properties.getAssetReqMsg(),"");
	else return assetDao.getAssetModels(classificationName);
	}

	@Override
	public Response getSpecificAssetModel(String classificationName,String assetName) {
		//logger.info(this.getClass().getName()+" - getSpecificAssetModel/"+ assetName);
		if(classificationName == null || classificationName.trim().equals(""))
			return assetUtil.sendResponse(properties.getClassificationReqCode(),properties.getClassificationReqMsg(),"");
		else if(assetName == null || assetName.trim().equals(""))
			return assetUtil.sendResponse(properties.getAssetReqCode(),properties.getAssetReqMsg(),"");
		else return assetDao.getSpecificAssetModel(classificationName,assetName);
	}


	@Override
	public Response createClassification(String classificationName,String asset_details) {
		//logger.info(this.getClass().getName()+" - createClassification/"+ classificationName);
		asset_details = assetUtil.checkStringValid(asset_details);
		if(asset_details == null){
			return assetUtil.sendResponse(properties.getNoDataCode(),properties.getNoDataMsg(),"");
		}else if(classificationName == null || classificationName.trim().equals(""))
			return assetUtil.sendResponse(properties.getClsNameReqCode(),properties.getClsNameReqMsg(),"");
		else return assetDao.createClassification(classificationName,asset_details);
	}

	@Override
	public Response getClassifications(String clssificationName,String pageSize) {
		//logger.info(this.getClass().getName()+" - getClassifications/"+ clssificationName);
	 if(clssificationName == null || clssificationName.trim().equals(""))
		return assetUtil.sendResponse(properties.getClsNameReqCode(),properties.getClsNameReqMsg(),"");
	else return assetDao.getClassifications(clssificationName,pageSize);
	}

	@Override
	public Response getSpecificClassification(String classification,String classificationName) {
		if(classification == null || classification.trim().equals(""))
			return assetUtil.sendResponse(properties.getClassificationReqCode(),properties.getClassificationReqMsg(),"");
		else if(classificationName == null || classificationName.trim().equals(""))
			return assetUtil.sendResponse(properties.getClsNameReqCode(),properties.getClsNameReqMsg(),"");
		else return assetDao.getSpecificClassifications(classification,classificationName);
	}

	@Override
	public Response deleteClassification(String classification,String classificationName) {
		if(classification == null || classification.trim().equals(""))
			return assetUtil.sendResponse(properties.getClassificationReqCode(),properties.getClassificationReqMsg(),"");
		else if(classificationName == null || classificationName.trim().equals(""))
			return assetUtil.sendResponse(properties.getClsNameReqCode(),properties.getClsNameReqMsg(),"");
		else return assetDao.deleteClassification(classification,classificationName);
	}

	@Override
	public Response getNamesInClassification(String classificationName) {
		//logger.info(this.getClass().getName()+" - getClassifications/"+ clssificationName);
	 if(classificationName == null || classificationName.trim().equals(""))
		return assetUtil.sendResponse(properties.getClsNameReqCode(),properties.getClsNameReqMsg(),"");
	else return assetDao.getNamesInClassification(classificationName);
	}

	@Override
	public Response getBlockClassificationNamesByLocation(String blockClassificatin, String locationName) {
		//logger.info(this.getClass().getName()+" - getClassifications/"+ clssificationName);
	 if(blockClassificatin == null || blockClassificatin.trim().equals(""))
		return assetUtil.sendResponse(properties.getClsNameReqCode(),properties.getClsNameReqMsg(),"");
	else return assetDao.getBlockClassificationNamesByLocation(blockClassificatin,locationName);
	}

	@Override
	public Response getCBClassificationNamesByBlock(
			String cBClassificationName, String blockName) {
	 if(cBClassificationName == null || cBClassificationName.trim().equals(""))
		return assetUtil.sendResponse(properties.getClsNameReqCode(),properties.getClsNameReqMsg(),"");
	else return assetDao.getCBClassificationNamesByBlock(cBClassificationName,blockName);
	}

	@Override
	public Response getInverterNamesByCB(String invClassificationName,
			String cbName,boolean flag) {
		 if(invClassificationName == null || invClassificationName.trim().equals(""))
				return assetUtil.sendResponse(properties.getClsNameReqCode(),properties.getClsNameReqMsg(),"");
			else return assetDao.getInverterNamesByCB(invClassificationName,cbName,flag);
			}

	@Override
	public Response getPanelsByInverter(String panelClassificationName,
			String inverterName) {
		 if(panelClassificationName == null || panelClassificationName.trim().equals(""))
				return assetUtil.sendResponse(properties.getClsNameReqCode(),properties.getClsNameReqMsg(),"");
			else return assetDao.getPanelsByInverter(panelClassificationName,inverterName);
			}

	
	@Override
	public Response getInvertersTimeSeriesTags(String location, String block,
			String cb) {
			return assetDao.getInvertersTimeSeriesTags(location,block,cb);
			}

	@Override
	public Response getAssetNames(String assetName) {
		//logger.info(this.getClass().getName()+" - getAssetModels/"+ classificationName);
	 if(assetName == null || assetName.trim().equals(""))
		return assetUtil.sendResponse(properties.getAssetReqCode(),properties.getAssetReqMsg(),"");
	else return assetDao.getAssetNames(assetName);
	}

	@Override
	public Response getWetherInfo() {
		return assetDao.getWetherInfo();
	}

	@Override
	public String createValue(String value) {
		try{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		testMap.put(formatter.format(new Date()),value);
		return " Value " + value + " Inserted Successfully";
		}catch(Exception e){
			return "Failure! Try Again";
		}
	}

	@Override
	public Map<String, String> getStoredValues() {
		return testMap;
	}

	
	
}
