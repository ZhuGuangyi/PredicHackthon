/**
 * @author SY00489214
 * 
 * This is Solar Asset Service Controller
 */

package com.TechMahindra.Asset.Controller;

import java.util.Date;
import java.util.Map;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.TechMahindra.Asset.Beans.Response;
import com.TechMahindra.Asset.Services.PredixAssetServices;
import com.TechMahindra.Asset.Utils.TokenUtil;

@RestController
@ComponentScan("com.TechMahindra")
public class AssetController {

	//private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TokenUtil tokenUtil;
	@Autowired
	private PredixAssetServices predixServices;
	
    @RequestMapping(value = "/Asset/ClientAuthentication",method = RequestMethod.GET)
	public String authenticateUser(){
    	String token = tokenUtil.getToken();
    	return token;
	}
    
    
/**
 * This method will store the asserts of classifications on predix cloud
 * 
 * @param classificationName
 * @param assetModelDetails
 * @return Response Bean
 */
    @RequestMapping(value = "/Asset/createAssetModel/{classificationName}", method = RequestMethod.POST)
    public Response createAssetModel(@PathVariable(value = "classificationName")String classificationName,
    		@RequestBody String assetModelDetails){
    	//logger.info(this.getClass().getName()+" - createClassification/"+ assetModelDetails);
    	return predixServices.createAsset(classificationName,assetModelDetails);
    }
    
    
    /**
     * This method will read, all asset models on specified 
     * 
     * @param classificationName
     * @return
     */
    @RequestMapping(value = "/Asset/getAssetModels/{classificationName}", method =  RequestMethod.GET)
    public Response getAssetModels(@PathVariable(value = "classificationName") String classificationName){
    	//logger.info(this.getClass().getName()+" - getAssetModels/"+ classificationName);
    	return predixServices.getAssetModels(classificationName);
    }
    
    @RequestMapping(value = "/Asset/getSpecificAssetModel/{classificationName}/{assetName}", method =  RequestMethod.GET)
    public Response getSpecificAssetModel(@PathVariable(value = "classificationName") String classificationName,@PathVariable(value = "assetName") String assetName){
    	//logger.info(this.getClass().getName()+" - getSpecificAssetModel/"+classificationName+"/"+ assetName);
    	return predixServices.getSpecificAssetModel(classificationName,assetName);
    }
    
    /**
     * This method will store the classification details on predix cloud
     * 
     */
    @RequestMapping(value = "/Asset/createClassification/{clssificationName}", method = RequestMethod.POST)
    public Response createClassification(@PathVariable(value = "clssificationName") String clssificationName,@RequestBody String classifications){
    	//logger.info("AssetController - createClassification/"+ clssificationName);
    	return predixServices.createClassification(clssificationName,classifications);
    }
	
    @RequestMapping(value = "/Asset/getNamesInClassification/{clssificationName}", method = RequestMethod.GET)
    public Response getNamesInClassification(@PathVariable(value = "clssificationName") String clssificationName){
    	//logger.info("AssetController - createClassification/"+ clssificationName);
    	return predixServices.getNamesInClassification(clssificationName);
    }
	
    /**
     * This method will read the all classifications from predix cloud asset database
     */
    @RequestMapping(value = "/Asset/getClassifications/{classification}", method = RequestMethod.GET)
    public Response getClassification(@PathVariable(value = "classification") String classification,@DefaultValue("125") @QueryParam(value = "pageSize") String pageSize){
    	//logger.info(this.getClass().getName()+" - getClassifications/"+ classification);
    	return predixServices.getClassifications(classification,pageSize);
    }
    
    /**
     * This method will read the specific classification details from predix cloud asset database
     */
    @RequestMapping(value = "/Asset/getSpecificClassification/{classification}/{classificationName}", method = RequestMethod.GET)
    public Response getSpecificClassification(@PathVariable(value = "classification") String classification,
    		@PathVariable(value = "classificationName") String classificationName){
    	//logger.info(this.getClass().getName()+" - getSpecificClassification/"+ classification +"/"+classificationName);
    	return predixServices.getSpecificClassification(classification,classificationName);
    }
    
    /**
     * This method will read the specific classification details from predix cloud asset database
     */
    @RequestMapping(value = "/Asset/deleteClassification/{classification}/{classificationName}", method = RequestMethod.DELETE)
    public Response deleteClassification(@PathVariable(value = "classification") String classification,
    		@PathVariable(value = "classificationName") String classificationName){
    	//logger.info(this.getClass().getName()+" - deleteClassification/"+ classification+"/"+classificationName);
    	return predixServices.deleteClassification(classification,classificationName);
    }
    
    @RequestMapping(value = "/Asset/getBlockClassificationNamesByLocation/{blockClassificatin}/{locationName}", method = RequestMethod.GET)
    public Response getBlockClassificationNamesByLocation(@PathVariable(value = "blockClassificatin") String blockClassificatin,
    		@PathVariable(value = "locationName") String locationName){
    	//logger.info(this.getClass().getName()+" - getSpecificClassification/"+ classification +"/"+classificationName);
    	return predixServices.getBlockClassificationNamesByLocation(blockClassificatin,locationName);
    } 
    
    @RequestMapping(value = "/Asset/getCBClassificationNamesByBlock/{CBClassificationName}/{blockName}", method = RequestMethod.GET)
    public Response getCBClassificationNamesByBlock(@PathVariable(value = "CBClassificationName") String CBClassificationName,
    		@PathVariable(value = "blockName") String blockName){
    	//logger.info(this.getClass().getName()+" - getSpecificClassification/"+ classification +"/"+classificationName);
    	return predixServices.getCBClassificationNamesByBlock(CBClassificationName,blockName);
    } 
    
    @RequestMapping(value = "/Asset/getInverterNamesByCB/{invClassificationName}/{cbName}", method = RequestMethod.GET)
    public Response getInverterNamesByCB(@PathVariable(value = "invClassificationName") String invClassificationName,
    		@PathVariable(value = "cbName") String cbName, @QueryParam(value = "isAll")boolean isAll){
    	//logger.info(this.getClass().getName()+" - getSpecificClassification/"+ classification +"/"+classificationName);
    	return predixServices.getInverterNamesByCB(invClassificationName,cbName,isAll);
    }
    
    
    
    @RequestMapping(value = "/Asset/getPanelsByInverter/{panelClassificationName}/{inverterName}", method = RequestMethod.GET)
    public Response getPanelsByInverter(@PathVariable(value = "panelClassificationName") String panelClassificationName,
    		@PathVariable(value = "inverterName") String inverterName){
    	//logger.info(this.getClass().getName()+" - getSpecificClassification/"+ classification +"/"+classificationName);
    	return predixServices.getPanelsByInverter(panelClassificationName,inverterName);
    }
    
    @RequestMapping(value = "/Asset/getInvertersTimeSeriesTags/{location}/{block}/{cb}", method = RequestMethod.GET)
    public Response getInvertersTimeSeriesTags(@PathVariable(value = "location") String location,
    		@PathVariable(value = "block") String block,@PathVariable(value = "cb") String cb){
    	System.out.println("Location : " + location);
    	//logger.info(this.getClass().getName()+" - getSpecificClassification/"+ classification +"/"+classificationName);
    	return predixServices.getInvertersTimeSeriesTags(location,block,cb);
    }
    
    @RequestMapping(value = "/Asset/getAssetNames/{assetName}", method = RequestMethod.GET)
    public Response getAssetNames(@PathVariable(value = "assetName") String assetName
    		){
    	System.out.println("Location : " + assetName);
    	//logger.info(this.getClass().getName()+" - getSpecificClassification/"+ classification +"/"+classificationName);
    	return predixServices.getAssetNames(assetName);
    }
    
    @RequestMapping(value = "/Asset/getWetherInfo", method = RequestMethod.GET)
    public Response getWetherInfo(){
    	return predixServices.getWetherInfo();
    }
   /* @RequestMapping(value = "/Asset/getCBAssetNamesByBlock/{CBClassificationName}/{blockName}", method = RequestMethod.GET)
    public Response getCBAssetNamesByBlock(@PathVariable(value = "CBClassificationName") String CBClassificationName,
    		@PathVariable(value = "blockName") String blockName){
    	//logger.info(this.getClass().getName()+" - getSpecificClassification/"+ classification +"/"+classificationName);
    	return predixServices.getCBClassificationNamesByBlock(CBClassificationName,blockName);
    } */
    
    @RequestMapping(value = "/Test/StoreValue/{value}", method = RequestMethod.GET)
    public String storeValue(@PathVariable(value = "value") String value
    		){
    	System.out.println("value : " + value);
    	//logger.info(this.getClass().getName()+" - getSpecificClassification/"+ classification +"/"+classificationName);
    	return predixServices.createValue(value);
    }
    
    @RequestMapping(value = "/Test/getStoredValues", method = RequestMethod.GET)
    public Map<String,String> getStoredValues(){
    	return predixServices.getStoredValues();
    }
}
