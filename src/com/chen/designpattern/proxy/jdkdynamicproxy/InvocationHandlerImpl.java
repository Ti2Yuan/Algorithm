/**
 * 
 */
package com.chen.designpattern.proxy.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实现InvocationHandler接口，重写invoke方法，用来处理Proxy所有方法调用。
 */
public class InvocationHandlerImpl implements InvocationHandler {
	
	private Object object;
	
	public InvocationHandlerImpl(Object object) {
		this.object = object;
	}

	/* TODO
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("computer will be used to do some thing------");
		System.out.println(proxy.getClass().getName());
		method.invoke(object, args);
		System.out.println("finished------");
		return null;
	}

}
