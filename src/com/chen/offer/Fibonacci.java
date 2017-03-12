/**
 * 
 */
package com.chen.offer;

/**
 *斐波那契数列
 *
 *1.递归。。重复计算节点
 *2.循环。。较好
 */
public class Fibonacci {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(fibonacci(90));
		System.out.println(fibonacci2(900));
	}

	
	public static int fibonacci(int n){
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		return fibonacci(n-1)+fibonacci(n-2);
	}
	
	public static long fibonacci2(int n){
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		long pre = 0;
		long mid = 1;
		long post = 0;
		for(int i = 2;i<= n;i++){
			post = pre+mid;
			pre = mid;
			mid = post;
		}
		return post;
	}
}
