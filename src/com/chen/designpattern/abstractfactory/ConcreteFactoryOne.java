/**
 * 
 */
package com.chen.designpattern.abstractfactory;

/**
 * 第一个具体工厂
 */
public class ConcreteFactoryOne implements Factory {

	/* TODO
	 * @see com.chen.designpattern.abstractfactory.Factory#makeProductA()
	 * @return
	 */
	@Override
	public AbstractProductA makeProductA() {
		// TODO Auto-generated method stub
		return new ConcreteProductA1();
	}

	/* TODO
	 * @see com.chen.designpattern.abstractfactory.Factory#makeProductB()
	 * @return
	 */
	@Override
	public AbstractProductB makeProductB() {
		// TODO Auto-generated method stub
		return new ConcreteProductB1();
	}

}
