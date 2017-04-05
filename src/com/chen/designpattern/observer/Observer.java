/**
 * 
 */
package com.chen.designpattern.observer;

/**
 * 观察者接口类
 */
public interface Observer {

	/**
	 * 
	 * TODO 状态更新时每个观察者执行的接口方法
	 * @param newState 更新的状态
	 * void
	 */
	public void update(String newState);
}
