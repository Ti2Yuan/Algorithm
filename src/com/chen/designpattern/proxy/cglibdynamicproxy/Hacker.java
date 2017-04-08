/**
 * 
 */
package com.chen.designpattern.proxy.cglibdynamicproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 实现了方法拦截器接口(cglib.jar中的接口类)
 */
public class Hacker implements MethodInterceptor {

	/* TODO
	 * @see net.sf.cglib.proxy.MethodInterceptor#intercept(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], net.sf.cglib.proxy.MethodProxy)
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("will hack, change source code------");
		proxy.invokeSuper(obj, args);
		System.out.println("succeed!");
		return null;
	}

}
