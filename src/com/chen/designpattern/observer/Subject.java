/**
 * 
 */
package com.chen.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象主题角色（抽象被观察者角色）
 */
public abstract class Subject {

	/**
	 * 用来保存注册到这个主题的观察者对象
	 */
	private List<Observer> list = new ArrayList<Observer>();
	
	/**
	 * 
	 * TODO 将参数中观察者对象注册到此主题中
	 * @param observer 观察者对象
	 * void
	 */
	public void register(Observer observer){
		list.add(observer);
	}
	
	/**
	 * 
	 * TODO 将参数中观察者对象从注册队列中删除
	 * @param observer 观察着对象
	 * void
	 */
	public void unregister(Observer observer){
		list.remove(observer);
	}
	
	/**
	 * 
	 * TODO 当特定主题状态改变时，通知所有观察者对象
	 * @param newState
	 * void
	 */
	public void notifyObservers(String newState){
		for (Observer observer : list) {
			observer.update(newState);
		}
	}
}
