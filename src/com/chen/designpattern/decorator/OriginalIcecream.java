package com.chen.designpattern.decorator;

/**
 * a concrete implementation of this interface. 
 * This is the base class on which the decorators will be added. 
 *
 */
public class OriginalIcecream implements Icecream {

	@Override
	public String makeIcecream() {
		// TODO Auto-generated method stub
		return "base icecream";
	}

}
