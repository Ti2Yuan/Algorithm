/**
 * 
 */
package com.chen.designpattern.observer;

/**
 * 具体的主题角色类，可为这个具体的主题角色绑定一个或多个观察者，当该主题特定状态改变时，绑定的观察者能立即接收到通知
 */
public class ConcreteSubject extends Subject {

	private String state;

	public String getState() {
		return state;
	}

	public void change(String newState) {
		if (state != null) {
			if (state.equals(newState)) {
				return;
			}
		}
		System.out.println("state update: " + state + " ---> " + newState);
		state = newState;
		// 通知注册到这个主题的观察者
		notifyObservers(newState);
	}
}
