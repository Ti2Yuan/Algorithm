/**
 * 
 */
package com.chen.blockingqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * solution 1 for implementing blocking queue
 */
public class ImplementBlockingQueue<T> {

	private final T[] items;
	private final Lock lock = new ReentrantLock();
	private Condition notFull = lock.newCondition();
	private Condition notEmpty = lock.newCondition();
	private int head, tail, count;

	@SuppressWarnings("unchecked")
	public ImplementBlockingQueue(int maxSize) {
		items = (T[]) new Object[maxSize];
	}

	public ImplementBlockingQueue() {
		this(10);
	}

	public void put(T t) throws InterruptedException {
		lock.lock();
		try {
			while (count == items.length) {
				// 数组满时，线程进入等待队列挂起。线程被唤醒时，从这里返回。
				notFull.await();
			}
			items[tail] = t;
			if (++tail == items.length) {
				tail = 0;
			}
			++count;
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	public T take() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0) {
				notEmpty.await();
			}
			T o = items[head];
			items[head] = null;// GC
			if (++head == items.length) {
				head = 0;
			}
			--count;
			notFull.signal();
			return o;
		} finally {
			lock.unlock();
		}
	}
}
