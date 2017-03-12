/**
 * 
 */
package com.chen.designpattern.factorymethod;

/**
 * 客户要利用每个具体工厂生产具体产品
 */
public class Client {

	public static void main(String[] args){
		Factory factoryA = new FactoryA();
		Product productA = factoryA.makeProduct();
		productA.use();
		
		Factory factoryB = new FactoryB();
		Product productB = factoryB.makeProduct();
		productB.use();
	}
}
