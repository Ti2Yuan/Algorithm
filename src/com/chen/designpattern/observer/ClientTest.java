/**
 * 
 */
package com.chen.designpattern.observer;

/**
 * 测试 观察者模式
 */
public class ClientTest {

	public static void main(String[] args) {
		//创建主题角色
		ConcreteSubject subject = new ConcreteSubject();
		
		//创建观察者角色 1
		Observer observer1 = new ConcreteObserver1();
		
		//创建观察者角色 2
		Observer observer2 = new ConcreteObserver2();
		
		//将两个观察者注册到主题中
		subject.register(observer1);
		subject.register(observer2);
		
		//主题状态更新
		subject.change("this is a new string");
	}

}
