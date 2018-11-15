package com.equifax.automation.dataObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WebserviceResponseBody {
	
	private List<StateInfo> stateInfoList;
	
	public void getStateInfo() {
		
		RestAssured.baseURI = "http://services.groupkt.com/state/get/USA/all";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET);
		
		//System.out.println("Response: " + response.asString());
		stateInfoList = new ArrayList<StateInfo>();
		
		List<HashMap<String,Object>> result = response.getBody().jsonPath().getJsonObject("RestResponse.result");
		
		for(HashMap<String, Object> state : result) {
			StateInfo temp = new StateInfo();
			
			if(state.get("abbr")!=null) {
				temp.setAbbr(state.get("abbr").toString());
			}
			
			if(state.get("area")!=null) {
				temp.setArea(state.get("area").toString());
			}
			
			if(state.get("capital")!=null) {
				temp.setCapital(state.get("capital").toString());
			}
			
			if(state.get("country")!=null) {
				temp.setCountry(state.get("country").toString());
			}
			if(state.get("id")!=null) {
				temp.setId(state.get("id").toString());
			}
			if(state.get("largest_city")!=null) {
				temp.setLargest_city(state.get("largest_city").toString());
			}
			if(state.get("name")!=null) {
				temp.setName(state.get("name").toString());
			}
			
			stateInfoList.add(temp);
		}
		
	
	}
	
	public List<StateInfo> getStateInfoList() {
		return stateInfoList;
	}

	public void setStateInfoList(List<StateInfo> stateInfoList) {
		this.stateInfoList = stateInfoList;
	}

	@Override
	public String toString() {
		String str = null;
		for (StateInfo state: stateInfoList) {
			str += "\n"+ state.toString();
		}
		return str;
	}

}
