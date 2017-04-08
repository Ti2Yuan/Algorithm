/**
 * 
 */
package com.chen.designpattern.proxy.jdkdynamicproxy;

import java.lang.reflect.Proxy;

/**
 * JDK的动态代理创建机制-----通过接口
 * 
 * 比如现在想为RealSubject这个类创建一个动态代理对象，JDK主要会做以下工作：
    1.   获取 RealSubject上的所有接口列表；
    2.   确定要生成的代理类的类名，默认为：com.sun.proxy.$ProxyXXXX ；
    3.   根据需要实现的接口信息，在代码中动态创建 该Proxy类的字节码；
    4 .  将对应的字节码转换为对应的class 对象；
    5.   创建InvocationHandler 实例handler，用来处理Proxy所有方法调用；
    6.   Proxy 的class对象 以创建的handler对象为参数，实例化一个proxy对象

JDK通过 java.lang.reflect.Proxy包来支持动态代理，一般情况下，我们使用下面的newProxyInstance方法
static Object	newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
          返回一个指定接口的代理类实例，该接口可以将方法调用指派到指定的调用处理程序。
而对于InvocationHandler，我们需要实现下列的invoke方法：
在调用代理对象中的每一个方法时，在代码内部，都是直接调用了InvocationHandler 的invoke方法，而invoke方法根据代理类传递给自己的method参数来区分是什么方法。
 Object	invoke(Object proxy,Method method,Object[] args)
          在代理实例上处理方法调用并返回结果。
 */
public class JDKDynamicProxyClient {

	public static void main(String[] args) {
		Computer computer = new Computer();
		
		// 1.获取对应的ClassLoader
		ClassLoader classLoader = computer.getClass().getClassLoader();
		
		// 2.获取Computer所实现的所有接口
		Class[] interfaces = computer.getClass().getInterfaces();
		
		// 3.设置一个来自代理传过来的方法调用请求处理器，处理所有的代理对象上的方法调用
		InvocationHandlerImpl handler = new InvocationHandlerImpl(computer);
		
		// 4.创建代理对象
		Object o = Proxy.newProxyInstance(classLoader, interfaces, handler);
		
		Game game = (Game) o;
		game.play();
		
		System.out.println();
		
		Movie movie = (Movie) o;
		movie.watch();
	}

}
