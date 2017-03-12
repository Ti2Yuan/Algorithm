/**
 * 
 */
package com.chen.offer;

/**
 * 二进制中1的个数
 */
public class NumberOfOne {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 13;
		int m = 10;
		System.out.println(numberOfOne(n));
		System.out.println(numberOfOne2(n));
		System.out.println(isPowOfTwo(n));
		System.out.println(change(m, n));
	}

	//解法2：把一个整数减去1，再和原整数做运算，会把该整数最右边一个1变成0，那么一个整数的二进制表示有多少个1，就可以进行多少次这样的操作。
	public static int numberOfOne(int n){
		int x = n;
		int count = 0;
		while( x != 0){
			x = (x-1) & x;
			count++;
		}
		return count;
	}
	
	//解法1：考虑到输入的整数可能是负数，所以不能使用右移运算，这里可以采取左移运算。这个解法中循环的次数等于整数二进制的位数。
	//比如Java int类字节为32位，则要循环32次
	public static int numberOfOne2(int n){
		int count = 0;
		int flag = 1;
		while(flag != 0){
			if( (n & flag) != 0)
				count++;
			flag = flag << 1;
		}
		return count;
	}
	
	//用一条语句判断一个整数是不是2的整数次方
	//一个整数如果是2的整数次方，则二进制中只有一位为1
	public static boolean isPowOfTwo(int n){
		return ((n-1) & n) == 0 ? true:false;
	}
	
	//输入两个整数m 和 n，计算需要改变m的二进制中的多少位才能得到n。比如10的二进制1010,13的二进制1101，需要改变1010的3为才能得到1101.
	//第一步 ，异或，第二步，统计1的个数
	public static int change(int m, int n){
		int x = m ^ n;
		int count = 0;
		while(x != 0){
			x = (x-1) & x;
			count++;
		}
		return count;
	}
}
