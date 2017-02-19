/**
 * 
 */
package com.chen.offer;

/**
 * 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 
 * 分析可知，f(n)可以按照两种方式扩展，一种是f(n-1)组合1个2*1，另一种是f(n-2)组合2个2*1
 */
public class RectCover {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rectCover(3));
	}
	
	public static int rectCover(int target){
		if(target == 0)
			return 0;
		if(target == 1)
			return 1;
		if(target == 2)
			return 2;
		return rectCover(target-1) + rectCover(target-2);
	}

}
