/**
 * 
 */
package com.chen.designpattern.adapter;

/**
 * 模式所涉及的角色有：
 * 
 * ● 目标(Target)角色：这就是所期待得到的接口。注意：由于这里讨论的是类适配器模式，因此目标不可以是类。
 * 
 * ● 源(Adapee)角色：现在需要适配的接口。
 * 
 * ● 适配器(Adaper)角色：适配器类是本模式的核心。适配器把源接口转换成目标接口。显然，这一角色不可以是接口，而必须是具体类。
 * 
 * 给出的是目标角色的源代码，这个角色是以一个JAVA接口的形式实现的。可以看出，
 * 这个接口声明了两个方法：sampleOperation1()和sampleOperation2()。
 * 而源角色Adaptee是一个具体类，它有一个sampleOperation1()方法，但是没有sampleOperation2()方法。
 */
public interface Target {

	/**
	 * 这是源类Adaptee也有的方法 TODO void
	 */
	public void sampleOperation1();

	/**
	 * 这是源类Adaptee没有的方法 TODO void
	 */
	public void sampleOperation2();

}
