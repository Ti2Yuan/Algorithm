/**
 * 
 */
package com.chen.designpattern.adapter;

/**
 * 类的适配器模式一样，对象的适配器模式把被适配的类的API转换成为目标类的API，
 * 与类的适配器模式不同的是，对象的适配器模式不是使用继承关系连接到Adaptee类，
 * 而是使用委派关系连接到Adaptee类。
 * 
 * Adapter与Adaptee是委派关系，这决定了适配器模式是对象的。
 */
public class Adapter2 {

	private Adaptee2 adaptee2;
	
	public Adapter2(Adaptee2 adaptee2){
		this.adaptee2 = adaptee2;
	}

	/**
	 * 源类Adaptee有方法sampleOperaion1
	 * 因此适配器类直接委派即可
	 * TODO
	 * void
	 */
	public void sampleOperation1(){
		this.adaptee2.sampleOperation1();
	}
	
	/**
	 * 源类Adaptee没有方法sampleOperaion2，但是想用这个接口
	 * 因此由适配器类需要补充此方法
	 * TODO
	 * void
	 */
	public void sampleOperaion2(){
		//写相关代码
	}
}
