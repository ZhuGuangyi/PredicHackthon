
/**
 * @author SY00489214
 */

package com.TechMahindra.Asset.Utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.TechMahindra.Asset.Beans.Token;

@Service
public class TokenUtil {

	 public static Map<String,Object> tokenMap = new HashMap<String,Object>();
	 
	public String getToken() {
	   if(tokenMap.size() == 0){
		   setSystemProxyProperties(); // To configure the proxy property values , First we have to check proxy properties are required or not
		  return tokenId();
	   }else{
		   if(isTokenAlive())
			  return (String) tokenMap.get("tokenId");
		   else{
			   return tokenId();
		   }
	   }
  
   }

	private String tokenId() {
		 Token tokenObj = generateToken();
		   storeValuesInMap(tokenObj);
		   return tokenObj.getAccess_token();
	}

	public boolean isTokenAlive() {
			Date tokenCreatedOn = (Date)tokenMap.get("generatedat");
		   Date today = new Date();
		   long secs = (today.getTime() - tokenCreatedOn.getTime()) / 1000;
		   int hours = (int) (secs / 3600);    
		   System.out.println("Hours : " + hours + " Secs : " + secs);
		   if(secs <= 43100)
			   return true;
		   else
			   return false;
	}

	private void storeValuesInMap(Token tokenObj) {
		 	tokenMap.put("tokenId", tokenObj.getAccess_token());
		   tokenMap.put("expires", tokenObj.getExpires_in());
		   tokenMap.put("tokenType", tokenObj.getToken_type());
		   tokenMap.put("jti", tokenObj.getJti());
		   tokenMap.put("scope", tokenObj.getScope());
		   tokenMap.put("generatedat", new Date());
	}

	private Token generateToken() {
		String body = "grant_type=client_credentials";
		RestTemplate restTemplate = new RestTemplate();
		String plainClientCredentials="sy-client-id:sy-client-id";
		String base64ClientCredentials = new String(Base64.encodeBase64(plainClientCredentials.getBytes()));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64ClientCredentials);
		headers.add("Content-Type", "application/x-www-form-urlencoded");
		headers.add("Predix-Zone-Id","7536f3bb-7bd8-45bd-9270-9287453e4197");
		HttpEntity<String> request = new HttpEntity<String>(body,headers);
		Token obj = restTemplate.postForObject("https://7536f3bb-7bd8-45bd-9270-9287453e4197.predix-uaa.run.aws-usw02-pr.ice.predix.io/oauth/token",request,Token.class);
		//ResponseEntity<Token> response = restTemplate.exchange("https://7536f3bb-7bd8-45bd-9270-9287453e4197.predix-uaa.run.aws-usw02-pr.ice.predix.io", HttpMethod.POST, request, Token.class,map);
		System.out.println(obj);
		return obj;
	}

	public void setSystemProxyProperties() {
		System.getProperties().put("proxySet", "true");
	    System.getProperties().put("proxyHost", "localhost");
	    System.getProperties().put("proxyPort", "3128");
		
	}
	
	/*public static void main(String[] args) {
		System.out.println();
		TokenUtil u = new TokenUtil();
		System.out.println(u.getToken());
		
	}*/
}
