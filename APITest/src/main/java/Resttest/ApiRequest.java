package Resttest;
import org.json.JSONObject;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * @author Vijay Karthik
 * 
 *
 */
public  class ApiRequest {
	public Response response;
	public String jsonStr;
	public JSONObject jsonObj;
	public ObjectNode node = null;
	/**
	 * This method sends get API request and checks if any exception is thrown
	 */
	@Test
	public  void getRequest()  {
		try {
			response=RestAssured.get("https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method converts the JSON output generated from GET request to ObjectNode 
	 * so that it is easy to traverse JSON nodes.
	 */
	@Test
	public  void validateResponse() {
		jsonStr= response.asPrettyString();
		System.out.println(jsonStr);
		jsonObj = new JSONObject(jsonStr);
		String name = jsonObj.getString("Name");       
		try {
			node = new ObjectMapper().readValue(jsonStr, ObjectNode.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param Name
	 * @param CanRelist
	 * @param ProName
	 * @param ProDescription
	 * @return
	 * This method takes input from the feature file and compares with the JSON output
	 * generated out of GET method for the above mentioned parameters and if the value
	 * matches then it returns 1 else if it does not match then it returns 0
	 */
	@Test
	public int validateData(String Name,String CanRelist,String ProName,String ProDescription) {
		int pName1=0,name1=0,pDescription1=0,canRlist=0;
		Boolean CanRelist1=Boolean.parseBoolean(CanRelist);
		String name = jsonObj.getString("Name");
		Boolean canRelist = jsonObj.getBoolean("CanRelist");
		if(canRelist.equals(CanRelist1)) {
			canRlist=1;
		}
		String proName="";
		int Switch=0;
		for(int i=0; i<node.get("Promotions").findValues("Name").size();i++) {
			if( node.get("Promotions").findValues("Name").get(i).asText().equals(ProName)) {
				proName=ProName;	
				pName1=1;
				Switch=i;
				
			}	
		}
		String proDescription="";
		if( node.get("Promotions").findValues("Description").get(Switch).asText().equals(ProDescription)) {
			proDescription=ProDescription;	
			pDescription1=1;
		}
		
		if(jsonObj.getString("Name").equals(Name)&& (pDescription1==1) && (canRlist==1) && (pName1==1)) {
			name1=1;
		}
		return name1;
	}
}


