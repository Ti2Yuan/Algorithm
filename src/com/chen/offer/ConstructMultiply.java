/**
 * 
 */
package com.chen.offer;

/**
 * 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class ConstructMultiply {

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 对于任意一个i,都有
	 * 
	 * B[i] = A[0] * A[1] * ... * A[i-1] * A[i+1] * ... * A[n]
	 * 
	 * 那么，该等式右边，就可以分为2个部分，i之前的为一部分，i之后的为一部分
	 * 
	 * 所以，有：
	 * 
	 * before[i] = A[0] * A[1] * ... * A[i-1]
	 * 
	 * after[i] = A[i+1] * ... * A[n]
	 * 
	 * 而：
	 * 
	 * B[i] = before[i] * after[i]
	 *
	 * 
	 * 
	 * before和after各成一个数组，也就是本题的解题思路。
	 * 写一个before数组表示A[0]*....A[i-1]的值，after数组表示A[i]*....A[n-1]的值，最后一次循环把两个数组一乘就完事了
	 * TODO
	 * 
	 * @param A
	 * @return int[]
	 */
	public int[] multiply(int[] A) {
		if (A == null || A.length == 0)
			return null;
		int len = A.length;
		int[] before = new int[len];
		int[] after = new int[len];
		before[0] = after[len-1] = 1;
		for(int i = 1;i<len;i++){
			before[i] = before[i-1]*A[i-1];
			after[len-i-1] = after[len-i]*A[len-i];
		}
		for(int i = 0;i<len;i++){
			before[i] *= after[i];
		}
		return before;
	}
}
