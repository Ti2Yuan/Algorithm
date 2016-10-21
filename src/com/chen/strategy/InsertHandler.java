package com.chen.strategy;

public class InsertHandler implements IHandler {

	@Override
	public String handle(Object data) {
		User user = null;
		if(data instanceof User){
			user = (User) data;
		}
		return "insert into DB values ('"+ user.getName()+"',"+user.getAge()+",'"+user.getSex()+"')";
	}

}
