/**
 * 
 */
package com.chen.designpattern.singleinstance;

/**
 * 一般单例都是五种写法。懒汉，饿汉，双重校验锁，枚举和静态内部类。
 * 
 * 饿汉法  
 * 顾名思义，饿汉法就是在第一次引用该类的时候就创建对象实例，而不管实际是否需要创建。
 * 这样做的好处是编写简单，但是无法做到延迟创建对象。但是我们很多时候都希望对象可以尽可能地延迟加载，从而减小负载，所以就需要懒汉法：
 */
public class SingleInstance {

	private static SingleInstance singleInstance = new SingleInstance();
	
	private SingleInstance(){}
	
	public static SingleInstance getSingleInstance(){
		return singleInstance;
	}
}
