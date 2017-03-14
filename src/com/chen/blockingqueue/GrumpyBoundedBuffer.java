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
 * 将前提条件的失败传递给调用者
 */
public class GrumpyBoundedBuffer<V> extends BaseBoundedBuffer<V> {

	
	protected GrumpyBoundedBuffer(int capacity) {
		super(capacity);
	}
	
	//同步的put方法，前提条件失败抛出异常
	public synchronized void put(V v) throws Exception{
		if(isFull())
			throw new Exception("队列已满");
		doPut(v);
	}

	//同步的take方法，前提条件失败抛出异常
	public synchronized V take() throws Exception{
		if(isEmpty())
			throw new Exception("队列已空");
		return doTake();
	}
	
}
