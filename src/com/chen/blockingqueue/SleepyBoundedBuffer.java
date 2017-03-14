/**
 * 
 */
package com.chen.blockingqueue;

/**
 *书籍：《JAVA并发编程实战》
 * BaseBoundedBuffer,GrumpyBoundedBuffer,SleepyBoundedBuffer,BoundedBuffer和ConditionBoundedBuffer都是以不用策略实现条件队列的方式,
 * 将采用不同的方法来处理前提条件失败的问题。
 * 性能依次变好.
 * 
 * 通过轮询和休眠来实现简单的阻塞
 */
public class SleepyBoundedBuffer<V> extends BaseBoundedBuffer<V> {
	
	private static final int SLEEP_GRANULARITY = 2000;

	/**
	 * @param capacity
	 */
	protected SleepyBoundedBuffer(int capacity) {
		super(capacity);
	}
	
	public void put(V v) throws InterruptedException{
		while(true){
			synchronized (this) {
				if(!isFull()){
					doPut(v);
					return;
				}
			}
			Thread.sleep(SLEEP_GRANULARITY);
		}
	}
	
	public V take() throws InterruptedException{
		while(true){
			synchronized (this) {
				if(!isEmpty()){
					return doTake();
				}
			}
			Thread.sleep(SLEEP_GRANULARITY);
		}
	}

}
