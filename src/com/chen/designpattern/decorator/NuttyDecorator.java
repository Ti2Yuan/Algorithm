package com.chen.designpattern.decorator;

/**
 *  concrete class implementing the abstract decorator. 
 *  
 *  When the decorator is created the base instance is passed using the constructor 
 *  and is assigned to the super class. 
 *  In the makeIcecream method we call the base method followed by its own method addNuts(). 
 *  This addNuts() extends the behavior by adding its own steps.
 *
 */
public class NuttyDecorator extends IcecreamDecorator {
	
	public NuttyDecorator(Icecream icecream) {
		super(icecream);
	}

	public String makeIcecream() {
	    return icecream.makeIcecream() + addNuts();
	  }

	  private String addNuts() {
	    return " + cruncy nuts";
	  }
}
