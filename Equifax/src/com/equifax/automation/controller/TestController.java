package com.equifax.automation.controller;


import com.equifax.automation.dataObject.StateInfo;
import com.equifax.automation.dataObject.TestResult;
import com.equifax.automation.dataObject.WebserviceResponseBody;

public class TestController {
	
	WebserviceResponseBody web;
	
	public void initialize() {
		web = new WebserviceResponseBody();
		
		web.getStateInfo();
	}
	
	public TestResult testSearchStateName(String stateName) {
		
		//System.out.println("Entered State Name Search");
		String message = "";
		stateName = stateName.trim();
		
		TestResult testResult = new TestResult();
		
		if(stateName == null) {
			message = "Please enter valid name of a State.\n";
		} else if (stateName.matches(".*[0-9]+.*"))
		{
			message="State Name should not contain number.\n";
		
		} else if (stateName.matches("[a-zA-Z/./ ]+")) {
			//System.out.println("STATE VALUE CORRECT");
			boolean flag = false;
			for(StateInfo state: web.getStateInfoList()) {
				
				if(state.getName().equalsIgnoreCase(stateName)) {
					message += "State record found: " + state.getName() +"\n";
					flag=true;
					if(state.getLargest_city() == null || state.getCapital() == null) {
						
						if(state.getLargest_city() == null)
						{
							message += "Largest City Returned as Null\n";
							message +="Capital: " + state.getCapital() +"\n";
						} else if(state.getCapital() == null)
						{
							message += "Largest City: " + state.getLargest_city() + "\n";
							message += "Capital is returned as Null";
					
						}
					} else {
						testResult.setResult(true);
						message += "Largest City: " + state.getLargest_city() + "\n";
						message += "Capital: " + state.getCapital() + "\n";
					}
					break;
				} 
				
			}
			if(flag==false) {
				message += "State Not Found. Please enter correct State Name\n";
			}
			
		} else {
			message += "Enter correct State value \n";
		}
		
		
		testResult.setMessage(message);
		return testResult;
	}
	
	public TestResult testSearchStateAbbr(String stateAbbr) {
		
	String message = "";
	
	TestResult testResult = new TestResult();

	
	//System.out.println("Entered State Name Search");
	stateAbbr = stateAbbr.trim();
	
	
	if(stateAbbr == null) {
		message += "Please enter valid name of a State.\n";
	} else if (!stateAbbr.matches("..") ) {
		message += "State abbreviation can only be of 2 characters\n";
	}
	
	else if (stateAbbr.matches(".*[0-9]+.*"))
	{
		message += "State abbreviation should not contain number.\n";
	
	} else if (stateAbbr.matches("[a-zA-Z][a-zA-Z]")) {
		//System.out.println("STATE VALUE CORRECT");
		boolean flag = false;
		for(StateInfo state: web.getStateInfoList()) {
			
			if(state.getAbbr().equalsIgnoreCase(stateAbbr)) {
				message += "Record found for state: " + state.getAbbr() +"\n";
				flag=true;
				if(state.getLargest_city() == null || state.getCapital() == null) {
					
					if(state.getLargest_city() == null)
					{
						message += "Largest City Returned as Null\n";
						message += "Capital: " + state.getCapital() + "\n";
					} else if(state.getCapital() == null)
					{
						message += "Largest City: " + state.getLargest_city() + "\n";
						message += "Capital is returned as Null\n";
				
					}
				} else {
					testResult.setResult(true);
					message += "Largest City: " + state.getLargest_city() + "\n";
					message += "Capital: " + state.getCapital() +"\n";
				}
				break;
			} 
			
		}
		if(flag==false) {
			message += "State Not Found. Please enter correct State abbreviation\n";
		}
		
	} else {
		message += "Enter correct State abbreviation\n";
	}
	
	testResult.setMessage(message);
	return testResult;
	

	}




@Override
public String toString() {
	return web.toString();
}



}
