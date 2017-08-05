/**
 * 
 */
package com.chen.designpattern.facade;

/**
 * @author chenti
 *
 */
public class Facade {

	public void test() {
		ModleA a = new ModleA();
		a.testA();
		ModleB b = new ModleB();
		b.testB();
		ModleC c = new ModleC();
		c.testC();
	}
}
