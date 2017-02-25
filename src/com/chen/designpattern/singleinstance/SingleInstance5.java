/**
 * 
 */
package com.chen.designpattern.singleinstance;

/**
 * 静态内部类法：
 *  那么，有没有一种延时加载，并且能保证线程安全的简单写法呢？
 * 我们可以把Singleton实例放到一个静态内部类中，这样就避免了静态实例在Singleton类加载的时候就创建对象，
 * 并且由于静态内部类只会被加载一次，所以这种写法也是线程安全的：
 */
public class SingleInstance5 {

	private static class Holder {
		private static final SingleInstance5 singleInstance5 = new SingleInstance5();
	}

	private SingleInstance5() {
	}

	/**
	 * 这种方式同样利用了classloder的机制来保证初始化instance时只有一个线程，这种方式是Singleton类被装载了，instance不一定被初始化。
	 * 因为Holder类没有被主动使用，只有显示通过调用getInstance方法时，才会显示装载Holder类，从而实例化instance。
	 * 并且由于静态内部类只会被加载一次，所以这种写法也是线程安全的
	 * TODO
	 * @return
	 * SingleInstance5
	 */
	public static SingleInstance5 getInstance() {
		return Holder.singleInstance5;
	}

	/**
	 * 但是，上面提到的5种实现方式都有两个共同的缺点：
	 * 1. 都需要额外的工作(Serializable、transient、readResolve())来实现序列化，否则每次反序列化一个序列化的对象实例时都会创建一个新的实例。
	 * 2. 可能会有人使用反射强行调用我们的私有构造器（如果要避免这种情况，可以修改构造器，让它在创建第二个实例的时候抛异常）。
	 */
}
