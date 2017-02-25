/**
 * 
 */
package com.chen.designpattern.singleinstance;

/**
 * 懒汉法（单线程法）：
 * 这种写法是最简单的，由私有构造器和一个公有静态工厂方法构成，在工厂方法中对singleton进行null判断，
 * 如果是null就new一个出来，最后返回singleton对象。这种方法可以实现延时加载，但是有一个致命弱点：线程不安全。
 * 如果有两条线程同时调用getSingleton()方法，就有很大可能导致重复创建对象。
 */
public class SingleInstance2 {

	private static SingleInstance2 singleInstance2 = null;
	
	private SingleInstance2(){}
	
	public static SingleInstance2 getInstance(){
		if(singleInstance2 == null)
			singleInstance2 = new SingleInstance2();
		return singleInstance2;
	}
}
