package com.chen.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 *   ����һ���Զ�����̳߳أ���ͨ��beforeExecute, afterExecute��terminated�ȷ����������־��¼��ͳ����Ϣ�ռ���
 *
 */
public class Code_8_9 {

	
	public class TimingThreadPool extends ThreadPoolExecutor{
		
		private final ThreadLocal<Long> startTime = new ThreadLocal<Long>();
		private final Logger log = Logger.getLogger("TimingThreadPool");
		private final AtomicLong numTask =  new AtomicLong();
		private final AtomicLong  totalTime = new AtomicLong();

		public TimingThreadPool(int corePoolSize, int maximumPoolSize,
				long keepAliveTime, TimeUnit unit,
				BlockingQueue<Runnable> workQueue) {
			super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		}

		@Override
		protected void beforeExecute(Thread t, Runnable r) {
			super.beforeExecute(t, r);
			log.fine(String.format("Thread %s: start %s", t,r));
			startTime.set(System.nanoTime());
		}

		@Override
		protected void afterExecute(Runnable r, Throwable t) {
			try {
				long endTime = System.nanoTime();
				long taskTime = endTime - startTime.get();
				numTask.incrementAndGet();
				totalTime.addAndGet(taskTime);
				log.fine(String.format("Thread %s: end %s, time = %dns", r,r,taskTime));				
			} catch (Exception e) {
				super.afterExecute(r, t);
			}
		}

		@Override
		protected void terminated() {
			try {

				log.info(String.format("Terminated: avg time = %dns", totalTime.get()/numTask.get()));;
			} catch (Exception e) {
				super.terminated();
			}
		}
		
		
		
	}
}
