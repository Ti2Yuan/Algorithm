/**
 * 
 */
package com.chen.designpattern.singleinstance;

/**
 * 测试枚举类是否可以单例类
 */
public class TestSingleton {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleInstance6 single = SingleInstance6.INSTANCE;
		single.doSomeThing();
	}

}
