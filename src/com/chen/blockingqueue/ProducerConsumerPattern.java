/**
 * 
 */
package com.chen.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author chenti
 * 
 * 阻塞队列实现生产者消费者模型
 * 
 * 比较低级的办法是用wait和notify来解决这个问题
 * 比较赞的办法是用Semaphore 或者 BlockingQueue来实现生产者消费者模型
 *
 */
public class ProducerConsumerPattern {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>();
		
		Thread prodThread = new Thread(new Producer(sharedQueue));
		Thread consThread = new Thread(new Consumer(sharedQueue));
		
		consThread.start();
		try {			
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		prodThread.start();
	}
	
	/**
	 * 生产者
	 * @author chenti
	 *
	 */
	static class Producer implements Runnable{

		private final BlockingQueue<Integer> sharedQueue;
		
		public Producer(BlockingQueue<Integer> blockQueue) {
			this.sharedQueue = blockQueue;
		}
		@Override
		public void run() {
			for(int i = 0; i<10; i++){
				try {					
					System.out.println("produced: " + i);
					sharedQueue.offer(i);
				} catch (Exception e) {
					Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, e);
				}
			}
		}
		
	}

	/**
	 * 消费者
	 * @author chenti
	 *
	 */
	static class Consumer implements Runnable{

		private final BlockingQueue<Integer> sharedQueue;
		
		public Consumer(BlockingQueue<Integer> blockQueue) {
			this.sharedQueue = blockQueue;
		}
		@Override
		public void run() {
			while(true){
				try {					
					System.out.println("consumed: " + sharedQueue.take());
				} catch (Exception e) {
					Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, e);
				}
			}
		}
		
	}

}
