/**
 * 
 */
package com.chen.offer;

/**
 * 跳台阶 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 跳到第N级话，
 * 可以先跳N-1级，再跳1级；
 * 也可以先跳N-2级，再跳2级。
 * 所以f(n)=f(n-1)+f(n-2)，就是斐波那契数列。
 */
public class JumpFloor {

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		int target = 5;
		System.out.println(jumpFloor2(target));
	}

	/**
	 * 这个问题归根结底还是一个费布拉奇数列，仔细找一下规律即可，刚开始做的时候我是直接写出前六个数的结果来找规律的。
	 * 
	 * 一级台阶： 1种 fib(1)=1 
	 * 二级台阶：2种 fib(2)=2 
	 * 三级台阶：3种 fib(3)=fib(1)+fib(2)=3 
	 * 四级台阶：5种 fib(4)=fib(2)+fib(3)=5 
	 * 五级台阶：8种 fib(5)=fib(3)+fib(4)=8 
	 * 六级台阶：13种 fib(6)=fib(4)+fib(5)=13
	 * 
	 * 现在看出规律了吧，fib(n)=fib(n-1)+fib(n-2),fib(1)=1,fib(2)=2。 TODO
	 * 
	 * @param target
	 * @return int
	 */
	public static int jumpFloor(int target) {
		if (target == 1)
			return 1;
		if (target == 2)
			return 2;
		return jumpFloor(target - 1) + jumpFloor(target - 2);
	}

	// 循环实现上面递归算法
	public static int jumpFloor2(int target) {
		if (target == 1)
			return 1;
		if (target == 2)
			return 2;
		int i = 3;
		int sum = 0;
		int x = 1;
		int y = 2;
		while (i <= target) {
			sum = x + y;
			x = y;
			y = sum;
			i++;
		}
		return sum;
	}

	/**
	 * 变态跳台阶 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
	 * 
	 * 这个也是如上所示的推理方法，没什么技术含量。写出前六个的跳台阶的结果，这个有一部分在上面的已经数出来了，所以我们就只要算上可以跳2阶台阶以上的结果就行了。然后算出
	 * 
	 * 一级台阶：1种 f=fib(1)=1=2^1 
	 * 二级台阶：2种 f=fib(2)=2=2^2 
	 * 三级台阶：3种 f=fib(3)+1=4=2^3
	 * 四级台阶：5种 f=fib(4)+3=8=2^4 
	 * 五级台阶：8种 f=fib(5)+8=16=2^5 
	 * 六级台阶：13种 f=fib(6)+19=32=2^6
	 * 
	 * 然后这个思路清晰了，代码就好写了，和上面类似，都是考察递归和循环的知识点。
	 *  分析：用Fib(n)表示青蛙跳上n阶台阶的跳法数，青蛙一次性跳上n阶台阶的跳法数1(n阶跳)，设定Fib(0) = 1；
       当n = 1 时， 只有一种跳法，即1阶跳：Fib(1) = 1;
       当n = 2 时， 有两种跳的方式，一阶跳和二阶跳：Fib(2) = Fib(1) + Fib(0) = 2;
       当n = 3 时，有三种跳的方式，第一次跳出一阶后，后面还有Fib(3-1)中跳法； 第一次跳出二阶后，后面还有Fib(3-2)中跳法；第一次跳出三阶后，后面还有Fib(3-3)中跳法
        Fib(3) = Fib(2) + Fib(1)+Fib(0)=4;
       当n = n 时，共有n种跳的方式，第一次跳出一阶后，后面还有Fib(n-1)中跳法； 第一次跳出二阶后，后面还有Fib(n-2)中跳法..........................第一次跳出n阶后，后面还有 Fib(n-n)中跳法.
       Fib(n) = Fib(n-1)+Fib(n-2)+Fib(n-3)+..........+Fib(n-n)=Fib(0)+Fib(1)+Fib(2)+.......+Fib(n-1)
      又因为Fib(n-1)=Fib(0)+Fib(1)+Fib(2)+.......+Fib(n-2)
      两式相减得：Fib(n)-Fib(n-1)=Fib(n-1)         =====》  Fib(n) = 2*Fib(n-1)     n >= 2
	 */
	public static int jumpFloorII(int target) {
		if(target == 0 || target == 1)  
	        return 1;  
	    else  
	        return 2*jumpFloorII(target-1);
	}
}
