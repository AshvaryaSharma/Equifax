package com.equifax.automation.runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.equifax.automation.controller.TestController;
import com.equifax.automation.dataObject.TestResult;



public class UserInputTester {

	
	public static void main(String args [])
	{   
		
		
		TestController test = new TestController();
		test.initialize();
		
		
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in)); 
         
        // Reading data using readLine 
        String option = null;
        String flag = null;
		try {
			
			do {
				
				System.out.println("Select the parameter to be used for search :");
				System.out.println("A - State Name");
				System.out.println("B - State Abbreviation\n");
				option = reader.readLine();
				
				if(option.equalsIgnoreCase("a")) {
					System.out.println("Option Selected: Search By State Name");
					String state = null;
					System.out.println("Enter the State Name: ");
					state = reader.readLine();
					TestResult result = test.testSearchStateName(state);
					System.out.println(result.toString());
					
				} else if(option.equalsIgnoreCase("b")) {
					System.out.println("Option Selected: Search By State Abbreviation");
					String state = null;
					System.out.println("Enter the State Abbreviation: ");
					state = reader.readLine();
					TestResult result = test.testSearchStateAbbr(state);
					System.out.println(result.toString());
				} else {
					System.out.println("Please enter correct option.");
				}
				
				System.out.println("Do you wish to continue?(Y/N)"); 
				flag = reader.readLine();
				
			} while (flag.equalsIgnoreCase("y"));
			
		} catch (IOException e) {
			
			
		} 
  
        
           
        try {
        	reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
