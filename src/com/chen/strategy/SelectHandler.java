package com.chen.strategy;

public class SelectHandler implements IHandler {

	@Override
	public String handle(Object data) {
		String name = null;
		if(data instanceof String)
			name = (String) data;
		return "select * from DB where name='"+name+"'";
	}

}
