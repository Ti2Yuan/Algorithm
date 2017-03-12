/**
 * 
 */
package com.chen.designpattern.simplefactory;

/**
 * 客户，使用工厂创建产品
 */
public class Client {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product product = Factory.makeProduct("A");
		product.use();
		
		Product product2 = Factory.makeProduct("B");
		product2.use();
	}

}
