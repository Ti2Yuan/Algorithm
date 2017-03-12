/**
 * 
 */
package com.chen.designpattern.factorymethod;

/**
 * 具体工厂A
 */
public class FactoryA implements Factory {

	/* TODO
	 * @see com.chen.designpattern.factorymethod.Factory#makeProduct()
	 * @return
	 */
	@Override
	public Product makeProduct() {
		// TODO Auto-generated method stub
		return new ProductA();
	}

}
