/**
 * 
 */
package com.chen.blockingqueue;

import org.junit.runner.notification.RunListener.ThreadSafe;

/**
 * 书籍：《JAVA并发编程实战》
 * BaseBoundedBuffer,GrumpyBoundedBuffer,SleepyBoundedBuffer,BoundedBuffer和ConditionBoundedBuffer都是以不用策略实现条件队列的方式,
 * 将采用不同的方法来处理前提条件失败的问题。
 * 性能依次变好.
 * 
 * 这是有界缓存队列的基类，其中实现了一个基于数组的循环缓存。
 */
@ThreadSafe
public class BaseBoundedBuffer<V> {

	private final V[] buf;
	private int tail;
	private int head;
	private int count;
	
	protected BaseBoundedBuffer(int capacity){
		this.buf = (V[]) new Object[capacity];
	}
	
	//同步的doPut方法
	protected synchronized final void doPut(V v){
		buf[tail] = v;
		if(++tail == buf.length)
			tail = 0;
		++count;
	}
	
	//同步的doTake方法
	protected synchronized final V doTake(){
		V v = buf[head];
		buf[head] = null;
		if(++head == buf.length)
			head = 0;
		--count;
		return v;
	}
	
	//同步的判满方法
	protected synchronized final boolean isFull(){
		return count == buf.length;
	}
	
	//同步的判空方法
	protected synchronized final boolean isEmpty(){
		return count == 0;
	}
}
