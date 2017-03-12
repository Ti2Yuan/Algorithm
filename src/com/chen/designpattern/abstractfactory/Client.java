/**
 * 
 */
package com.chen.designpattern.abstractfactory;

/**
 * 客户根据不同工厂方法生成不同产品族
 */
public class Client {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Factory factory1 = new ConcreteFactoryOne();
		AbstractProductA productA = factory1.makeProductA();
		AbstractProductB productB = factory1.makeProductB();
		productA.use();
		productB.use();
		
		Factory factory2 = new ConcreteFactoryTwo();
		AbstractProductA productA2 = factory2.makeProductA();
		AbstractProductB productB2 = factory2.makeProductB();
		productA2.use();
		productB2.use();
	}

}
