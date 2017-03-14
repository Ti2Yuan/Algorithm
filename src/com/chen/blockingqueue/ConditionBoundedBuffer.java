/**
 * 
 */
package com.chen.blockingqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 书籍：《JAVA并发编程实战》
 * BaseBoundedBuffer,GrumpyBoundedBuffer,SleepyBoundedBuffer,BoundedBuffer和ConditionBoundedBuffer都是以不用策略实现条件队列的方式,
 * 将采用不同的方法来处理前提条件失败的问题。
 * 性能依次变好.
 * 
 * 使用显示条件变量的有界缓存
 *
 */
public class ConditionBoundedBuffer<T> {

	private static final int BUFFER_SIZE = 16;
	
	protected final Lock lock = new ReentrantLock();
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();
	private final T[] items = (T[]) new Object[BUFFER_SIZE];
	private int tail,head,count;
	
	//则塞直到not-full
	public void put(T t){
		lock.lock();
		try {
			while(count == items.length)
				notFull.await();
			items[tail] = t;
			if(++tail == items.length)
				tail = 0;
			++count;
			notEmpty.signal();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	//则塞直到not-empty
	public T take(){
		T t = null;
		lock.lock();
		try {
			if(count == 0)
				notEmpty.await();
			t = items[head];
			if(++head == items.length)
				head = 0;
			--count;
			notFull.signal();
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		return t;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
