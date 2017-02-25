/**
 * 
 */
package com.chen.designpattern.adapter;

/**
 * 适配器模式将一个类的接口适配成用户所期待的。一个适配允许通常因为接口不兼容而不能在一起工作的类工作在一起，做法是将类自己的接口包裹在一个已存在的类中。
 * 概念定义表明，适配器模式就是当前我们的接口是不符合我们使用要求的，我们通过适配器模式将其转化，即为将一个接口转化为另一个接口，然后再使用。
 * 就好比，我们在给手机充电的时候，我们直接将usb线插进插座里，肯定是不可以的，我们需要将usb线先插入到一个适配器里，
 * 然后适配器插到插座上，我们才可以正常使用。这个概念理解起来还是相对比较简单的。
 * 
 * 适配器模式的结构 适配器模式有类的适配器模式和对象的适配器模式两种不同的形式。
 * 
 * 类的适配器模式把适配的类的API转换成为目标类的API。(Target.java, Adaptee,java, Adapter.java)
 * 与类的适配器模式一样，对象的适配器模式把被适配的类的API转换成为目标类的API，(Target2.java, Adaptee2,java, Adapter2.java) 
 * 与类的适配器模式不同的是，对象的适配器模式不是使用继承关系连接到Adaptee类，而是使用委派关系连接到Adaptee类。
 * 
 * 适配器模式的优点 
 *    更好的复用性 系统需要使用现有的类，而此类的接口不符合系统的需要。那么通过适配器模式就可以让这些功能得到更好的复用。
 * 
 *    更好的扩展性 在实现适配器功能的时候，可以调用自己开发的功能，从而自然地扩展系统的功能。
 * 
 * 适配器模式的缺点
 *    过多的使用适配器，会让系统非常零乱，不易整体进行把握。比如，明明看到调用的是A接口，其实内部被适配成了B接口的实现，
 *    一个系统如果太多出现这种情况，无异于一场灾难。因此如果不是很有必要，可以不使用适配器，而是直接对系统进行重构。
 * 
 * Adapter与Adaptee是继承关系，这决定了这个适配器模式是类的
 */
public class Adapter extends Adaptee implements Target {

	/*
	 * TODO
	 * 
	 * @see com.chen.designpattern.adapter.Target#sampleOperation2()
	 */
	@Override
	public void sampleOperation2() {
		// TODO Auto-generated method stub

	}

	/**
	 * 适配器角色Adapter扩展了Adaptee,同时又实现了目标(Target)接口。
	 * 由于Adaptee没有提供sampleOperation2()方法，而目标接口又要求这个方法，因此适配器角色Adapter实现了这个方法。
	 */
}
