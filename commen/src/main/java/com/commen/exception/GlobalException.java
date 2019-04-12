package com.commen.exception;


import com.commen.pojo.RestData;

@SuppressWarnings("serial")
public class GlobalException extends RuntimeException{
	
	private RestData restData;
	
	private Exception exception;
	
	public RestData getRestData() {
		return restData;
	}
	public void setRestData(RestData restData) {
		this.restData = restData;
	}
	public Exception getException() {
		return exception;
	}
	public void setException(Exception exception) {
		this.exception = exception;
	}
	public GlobalException(RestData restData, Exception exception) {
		super();
		this.restData = restData;
		this.exception = exception;
	}
}
