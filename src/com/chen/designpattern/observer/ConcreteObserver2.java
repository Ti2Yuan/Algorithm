/**
 * 
 */
package com.chen.designpattern.observer;

/**
 * 具体观察者 2
 *
 */
public class ConcreteObserver2 implements Observer {

	/* TODO
	 * @see com.chen.designpattern.observer.Observer#update(java.lang.String)
	 * @param newState
	 */
	@Override
	public void update(String newState) {
		System.out.println("具体观察者 2 接收到状态更新通知--------");
	}

}
