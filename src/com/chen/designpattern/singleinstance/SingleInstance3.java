/**
 * 
 */
package com.chen.designpattern.singleinstance;

/**
 * 懒汉法：（多线程安全）
 * 这种写法考虑了线程安全，将对singleton的null判断以及new的部分使用synchronized进行加锁。
 * 同时，对singleton对象使用volatile关键字进行限制，保证其对所有线程的可见性，并且禁止对其进行指令重排序优化。
 * 如此即可从语义上保证这种单例模式写法是线程安全的。注意，这里说的是语义上，实际使用中还是存在小坑的。
 * 其效率低下，还是无法实际应用。因为每次调用getSingleton()方法，都必须在synchronized这里进行排队，
 * 而真正遇到需要new的情况是非常少的。
 */
public class SingleInstance3 {

	private static volatile SingleInstance3 singleInstance3 = null;
	
	private SingleInstance3(){}
	
	//每次获取实例都试图加上一个同步锁，而加锁是一个非常耗时的操作，在没有必要的时候应该尽量避免
	public static SingleInstance3 getInstance(){
		synchronized (SingleInstance3.class) {
			if(singleInstance3 == null){
				singleInstance3 = new SingleInstance3();
			}
		}
		return singleInstance3;
	}
}
