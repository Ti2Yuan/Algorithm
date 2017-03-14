/**
 * 
 */
package com.chen.blockingqueue;

/**
 * 书籍：《JAVA并发编程实战》
 * BaseBoundedBuffer,GrumpyBoundedBuffer,SleepyBoundedBuffer,BoundedBuffer和ConditionBoundedBuffer都是以不用策略实现条件队列的方式,
 * 将采用不同的方法来处理前提条件失败的问题。
 * 性能依次变好.
 * 
 * 使用条件队列实现的有界缓存
 *
 */
public class BoundedBuffer<V> extends BaseBoundedBuffer<V> {

	/**
	 * @param capacity
	 */
	protected BoundedBuffer(int capacity) {
		super(capacity);
	}
	
	//则塞直到not-full
	public synchronized void put(V v) throws InterruptedException{
		if(isFull())
			wait();
		doPut(v);
		notifyAll();
	}

	//则塞直到not-empty
	public synchronized V take() throws InterruptedException{
		if(isEmpty())
			wait();
		V v = doTake();
		notifyAll();
		return v;
	}
}
