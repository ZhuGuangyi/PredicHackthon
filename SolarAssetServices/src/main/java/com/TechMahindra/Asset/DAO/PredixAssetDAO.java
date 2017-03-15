/**
 * @author SY00489214
 * 
 * DAO interface of Solar Asset Services
 */
package com.TechMahindra.Asset.DAO;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.TechMahindra.Asset.Beans.Response;

@Service
@ComponentScan("com.TechMahindra")
public interface PredixAssetDAO {

	public Response createAsset(String assetDetails,String asset_details);
	
	public Response getAssetModels(String classificationName);
	
	public Response getSpecificAssetModel(String classificationName,
			String assetName);

	public Response getNamesInClassification(String classificationName);
	
	public Response createClassification(String classificationName,String asset_details);

	public Response getClassifications(String clssificationName,String pageSize);

	public Response getSpecificClassifications(String classificationName,String assetName);

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

	Response getInvertersByCB(String invClassificationName, String cbName);

	public Response getAssetNames(String assetName);

	public Response getWetherInfo();

	

	
}
