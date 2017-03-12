/**
 * 
 */
package com.chen.designpattern.abstractfactory;

/**
 * 第二个具体工厂
 */
public class ConcreteFactoryTwo implements Factory {

	/* TODO
	 * @see com.chen.designpattern.abstractfactory.Factory#makeProductA()
	 * @return
	 */
	@Override
	public AbstractProductA makeProductA() {
		// TODO Auto-generated method stub
		return new ConcreteProductA2();
	}

	/* TODO
	 * @see com.chen.designpattern.abstractfactory.Factory#makeProductB()
	 * @return
	 */
	@Override
	public AbstractProductB makeProductB() {
		// TODO Auto-generated method stub
		return new ConcreteProductB2();
	}

}
