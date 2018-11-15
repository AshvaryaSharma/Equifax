package com.equifax.automation.runner;

import org.testng.annotations.Test;

import com.equifax.automation.controller.TestController;
import com.equifax.automation.dataObject.TestResult;

import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;


public class TestNGTestCases {
	
	TestController test;
 
 
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before test");
	  test = new TestController();
	  test.initialize();
  }

  
  
  @Test(dataProvider = "testDataScenarios")
  public void searchWebservice(String searchBy, String searchValue) {
	  //System.out.println("Test: " + searchBy);
	  TestResult result = new TestResult();
	  
	  System.out.println("Search By: " + searchBy + "\nValue: " + searchValue);
	  if(searchBy.equalsIgnoreCase("State Name")) {
		  result = test.testSearchStateName(searchValue);
	  } else if(searchBy.equalsIgnoreCase("State Abbr")) {
		  result = test.testSearchStateAbbr(searchValue);
	  }
	  System.out.println(result.getMessage());
	  Assert.assertEquals(true, result.isResult(), result.getMessage());
  }
  


  @DataProvider
  public Object[][] testDataScenarios() {
    return new Object[][] {
      { "State Name", "TeXAs" },
      { "State Name", "Alabama" },
      { "State Name", "Northern Mariana Islands" },
      { "State Name", "U.S. Virgin Islands" },
      { "State Name", "NoRtH cArOliNA" },
      { "State Name", "NewJersey" },
      { "State Name", "" },
      { "State Name", "    New Mexico    " },
      { "State Name", "Nev1ada" },
      { "State Name", "Nebr@ska" },
      { "State Name", null },
      { "State Abbr", "MO" },
      { "State Abbr", "tx" },
      { "State Abbr", "pR" },
      { "State Abbr", "Mp" },
      { "State Abbr", "MTT" },
      { "State Abbr", "M" },
      { "State Abbr", "" },
      { "State Abbr", null },
      { "State Name", "@L" },
    };
  }
  

}
