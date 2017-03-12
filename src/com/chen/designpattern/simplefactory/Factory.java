/**
 * 
 */
package com.chen.designpattern.simplefactory;

/**
 * 工厂类，根据传递产品参数不同制作产品
 */
public class Factory {
	
	public static Product makeProduct(String productType){
		switch (productType) {
		case "A":
			return new ProductA();
		case "B":
			return new ProductB();
		default:
			break;
		}
		return null;
	}
}
