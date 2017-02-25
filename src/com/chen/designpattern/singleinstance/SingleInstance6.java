/**
 * 
 */
package com.chen.designpattern.singleinstance;

/**
 * 枚举写法： 还有一种更加优雅的方法来实现单例模式，那就是枚举写法
 * 
 * 使用枚举除了线程安全和防止反射强行调用构造器之外，还提供了自动序列化机制，防止反序列化的时候创建新的对象。 
 * 因此，Effective Java推荐尽可能地使用枚举来实现单例。
 */
public enum SingleInstance6 {

	INSTANCE;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 代码没有一劳永逸的写法，只有在特定条件下最合适的写法。在不同的平台、不同的开发环境（尤其是jdk版本）下，自然有不同的最优解（或者说较优解）。
	 * 比如枚举，虽然Effective Java中推荐使用，但是在Android平台上却是不被推荐的。在这篇Android Training中明确指出：
	 * Enums often require more than twice as much memory as static constants.
	 * You should strictly avoid using enums on Android.
	 * 再比如双重检查锁法，不能在jdk1.5之前使用，而在Android平台上使用就比较放心了
	 * （一般Android都是jdk1.6以上了，不仅修正了volatile的语义问题，还加入了不少锁优化，使得多线程同步的开销降低不少）。
	 * 最后，不管采取何种方案，请时刻牢记单例的三大要点：
	 *  1. 线程安全 
	 *  2. 延迟加载 
	 *  3. 序列化与反序列化安全
	 */
}
