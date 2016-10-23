package com.chen.designpattern.decorator;

/**
 *the decorator class. 
 *
 *It is the core of the decorator design pattern. 
 *It contains an attribute for the type of interface. 
 *Instance is assigned dynamically at the creation of decorator using its constructor. 
 *Once assigned that instance method will be invoked. 
 *
 */
public abstract class IcecreamDecorator implements Icecream {
	
	protected Icecream icecream;
	
	public IcecreamDecorator(Icecream icecream) {
		this.icecream= icecream;
	}

	@Override
	public String makeIcecream() {
		// TODO Auto-generated method stub
		return icecream.makeIcecream();
	}

}
