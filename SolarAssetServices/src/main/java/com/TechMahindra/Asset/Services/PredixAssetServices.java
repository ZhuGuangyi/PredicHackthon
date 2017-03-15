/**
 * @author SY00489214
 * 
 *  
 */

package com.TechMahindra.Asset.Services;

import java.util.Date;
import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.TechMahindra.Asset.Beans.Response;

@Service
@ComponentScan("com.TechMahindra")
public interface PredixAssetServices {

	public Response createAsset(String classificationName,String asset_details);
	
	public Response getAssetModels(String classificationName);
	
	public Response getSpecificAssetModel(String classificationName,String assetName);
	
	public Response getNamesInClassification(String classificationName);
	/**
	 * This is for classification services
	 * 
	 * @param asset_details
	 * @return Response object
	 */
	public Response createClassification(String classificationName,String asset_details);

	public Response getClassifications(String clssificationName,String pageSize);

	public Response getSpecificClassification(String classificationName,String assetName);

	public Response deleteClassification(String classification,String classificationName);

	public Response getBlockClassificationNamesByLocation(
			String blockClassificatin, String locationName);

	public Response getCBClassificationNamesByBlock(String cBClassificationName, String blockName);

	public Response getInverterNamesByCB(String invClassificationName,
			String cbName,boolean flag);

	public Response getInvertersTimeSeriesTags(String location, String block,
			String cb);

	public Response getPanelsByInverter(String panelClassificationName,
			String inverterName);


	public Response getAssetNames(String assetName);

	public Response getWetherInfo();

	
	public String createValue(String value);

	public Map<String, String> getStoredValues();

	

	
	
}
