package com.chen.designpattern.decorator;

/**
 *concrete class implementing the abstract decorator. 
 *  
 *  When the decorator is created the base instance is passed using the constructor 
 *  and is assigned to the super class. 
 *  In the makeIcecream method we call the base method followed by its own method addHoney(). 
 *  This addHoney() extends the behavior by adding its own steps. 
 *
 */
public class HoneyDecorator extends IcecreamDecorator {

	public HoneyDecorator(Icecream icecream) {
		super(icecream);
	}

	public String makeIcecream() {
	    return icecream.makeIcecream() + addHoney();
	  }

	  private String addHoney() {
	    return " + sweet honey";
	  }
}
