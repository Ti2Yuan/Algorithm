package com.chen.designpattern.strategy;

public class Request<T> {
	
	private RequestType action;
	private T data;
	
	public Request(RequestType action){
		this.action = action;
	}
	
	public Request(RequestType action,T data){
		this(action);
		this.data = data;
	}
	
	public RequestType getAction() {
		return action;
	}
	public void setAction(RequestType action) {
		this.action = action;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	
}
