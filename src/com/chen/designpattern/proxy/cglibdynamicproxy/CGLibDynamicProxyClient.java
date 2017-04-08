/**
 * 
 */
package com.chen.designpattern.proxy.cglibdynamicproxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * cglib生成动态代理类的机制---通过类继承
 * 
 * JDK中提供的生成动态代理类的机制有个鲜明的特点是： 某个类必须有实现的接口，而生成的代理类也只能代理某个类接口定义的方法，
 * 比如：如果ElectricCar实现了继承自两个接口的方法外，另外实现了方法bee() ,则在产生的动态代理类中不会有这个方法了！
 * 更极端的情况是：如果某个类没有实现接口，那么这个类就不能同JDK产生动态代理了！
 * 
 * 幸好我们有cglib。“CGLIB（Code Generation Library），是一个强大的，高性能，高质量的Code生成类库，它可以在运行期扩展Java类与实现Java接口。”
 * 
 * cglib 创建某个类A的动态代理类的模式是：
1.   查找A上的所有非final 的public类型的方法定义；
2.   将这些方法的定义转换成字节码；
3.   将组成的字节码转换成相应的代理的class对象；
4.   实现 MethodInterceptor接口，用来处理 对代理类上所有方法的请求（这个接口和JDK动态代理InvocationHandler的功能和角色是一样的）
 */
public class CGLibDynamicProxyClient {

	public static void main(String[] args) {
		Programer programer = new Programer();
		
		Hacker hacker = new Hacker();
		
		//cglib加强器，用来创建动态代理
		Enhancer enhancer = new Enhancer();
		//设置要创建的动态代理的父类
		enhancer.setSuperclass(programer.getClass());
		
		//设置回调，相当于对于代理类上的所有方法的调用，都会调用Callback,而Callback又会调用intercept方法进行拦截
		enhancer.setCallback(hacker);
		
		Programer proxy = (Programer) enhancer.create();
		proxy.code();
		
	}

}
