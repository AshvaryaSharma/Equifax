package com.equifax.automation.dataObject;

public class TestResult {
	
	private boolean result;
	private String message;
	public TestResult() {
		result = false;
		message = null;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return message;
	}
	
	

}
