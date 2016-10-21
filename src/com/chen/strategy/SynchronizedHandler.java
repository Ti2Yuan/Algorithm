package com.chen.strategy;

public class SynchronizedHandler implements IHandler {

	@Override
	public String handle(Object data) {
		return "synchronized data with DB successfully!";
	}

}
