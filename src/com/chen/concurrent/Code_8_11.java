package com.chen.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ��һЩ�ݹ������ͬ�����Բ���ѭ�����л��ķ������ڵݹ��㷨��ͨ��������ڴ���ѭ���� ������Щѭ�����Խ��в��л���
 * һ�ּ򵥵�����ǣ���ÿ�����������ж�����Ҫ�����ں����ݹ�����Ľ����
 */
public class Code_8_11 {

	/**
	 * ����������㷨����һ��������ÿ���ڵ���ִ�м��㲢���������һ������
	 * 
	 * @param nodes
	 * @param results
	 */
	public <T> void sequentialRecursive(List<Node<T>> nodes,
			Collection<T> results) {
		for (Node<T> n : nodes) {
			results.add(n.compute());
			sequentialRecursive(n.getChildren(), results);
		}
	}

	/**
	 * ͬ��ִ��������ȱ����������������ڷ��ʽڵ�ʱ���м��㣬����Ϊÿ���ڵ��ύһ����������ɼ��㡣
	 * 
	 * @param <T>
	 * @param exec
	 * @param nodes
	 * @param results
	 */
	public <T> void parallelRecursive(final Executor exec, List<Node<T>> nodes,
			final Collection<T> results) {
		for (final Node<T> n : nodes) {
			exec.execute(new Runnable() {

				@Override
				public void run() {
					results.add(n.compute());
				}
			});
			parallelRecursive(exec, n.getChildren(), results);
		}
	}

	/**
	 * �ȴ�ͨ�����з�ʽ����Ľ��
	 * 
	 * @param nodes
	 * @return
	 * @throws InterruptedException
	 */
	public <T> Collection<T> getParallelResults(List<Node<T>> nodes)
			throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		Queue<T> resultQueue = new ConcurrentLinkedQueue<T>();
		parallelRecursive(exec, nodes, resultQueue);
		//shutdown()�����ڹر������̣߳���������ø���䣬jvm����رա�
        //awaitTermination()�����ڵȴ����߳̽������ټ���ִ������Ĵ��롣������������һֱ�������߳̽�����
		exec.shutdown();
		exec.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
		return resultQueue;
	}

	public class Node<T> {
		T value;
		Node<T> left;
		Node<T> right;

		public List<Node<T>> getChildren() {
			List<Node<T>> nodes = new ArrayList<Code_8_11.Node<T>>();
			nodes.add(this.left);
			nodes.add(this.right);
			return nodes;
		}

		public T compute() {
			T e = null;
			return e;
		}
	}
}
