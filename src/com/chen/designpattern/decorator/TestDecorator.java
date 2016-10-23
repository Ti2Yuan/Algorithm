package com.chen.designpattern.decorator;

/**
 *created a simple icecream and decorated that with nuts and on top of it with honey. 
 *We can use as many decorators in any order we want. 
 *This excellent flexibility and changing the behavior of an instance of our choice at runtime 
 * is the main advantage of the decorator design pattern. 
 *
 */
public class TestDecorator {

	public static void main(String[] args) {
		
		Icecream icecream = new OriginalIcecream();
		System.out.println(icecream.makeIcecream());
		
		Icecream specialIcecream = new HoneyDecorator(new NuttyDecorator(new OriginalIcecream()));
	    System.out.println(specialIcecream.makeIcecream());

	}

}
