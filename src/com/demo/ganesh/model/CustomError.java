package com.demo.ganesh.model;

public class CustomError {
	
	private String responseCode;
	private String responseString;
	/**
	 * @return the responseString
	 */
	public String getResponseString() {
		return responseString;
	}
	public CustomError(String responseCode, String responseString) {
		super();
		this.responseCode = responseCode;
		this.responseString = responseString;
	}
	/**
	 * @param responseString the responseString to set
	 */
	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}
	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}
	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	
}
