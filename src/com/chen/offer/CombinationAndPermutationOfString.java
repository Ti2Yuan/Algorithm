/**
 * 
 */
package com.chen.offer;

import java.lang.Thread.State;
import java.util.Stack;

/**
 * 字符串的全排列与组合
 * 
 */
public class CombinationAndPermutationOfString {

	public static void main(String[] args) {
		char[] t = new char[] { 'a', 'b', 'c' };
		permutation(t);
		combination(t);
	}

	/**
	 * 给一个字符串，比如ABC， 把所有的排列，即：ABC, ACB, BAC, BCA, CAB, CBC 都找出来。
	 * 
	 * 解题思路：
	 * 
	 * 对于一个n 位的字符串来讲，它是n-1位字符串的排列 加上 没有在 n -1 位字符串里 那个字符 的排列。 有点难理解，用例子说明：
	 * 
	 * 对于字符串ABC来讲，它所有的排列就是 A + BC 的排列 加上 B + AC 的排列，再加上 C + AB的排列。
	 * 
	 * 而BC的排列是 B + C 的排列 加上 C + B 的排列。
	 * 
	 * 所以，对一个字符串，我们从中去一个值，然后求剩余部分的排列，然后把它们再组合在一起。
	 */
	public static void permutation(char[] t) {
		if (t == null || t.length == 0)
			return;
		permutation(t, 0, t.length - 1);
	}

	public static void permutation(char[] t, int start, int end) {
		if (start == end) {
			for (int i = 0; i <= end; i++) {
				System.out.print(t[i] + " ");
			}
			System.out.println();
		} else {
			for (int i = start; i <= end; i++) {

				// 当两个元素相同时
				if (i != start && t[i] == t[start])
					continue;

				char temp = t[start];
				t[start] = t[i];
				t[i] = temp;

				permutation(t, start + 1, end);

				temp = t[start];
				t[start] = t[i];
				t[i] = temp;
			}
		}
	}

	/**
	 * 字符串的组合：
	 * 
	 * 给一个字符串，比如ABC， 把所有的组合，即：A, B, C, AB, AC, BC, ABC, 都找出来。
	 * 
	 * 解题思路：
	 * 
	 * 假设我们想在长度为n的字符串中求m个字符的组合。我们先从头扫描字符串的第一个字符。
	 * 针对第一个字符，我们有两种选择：一是把这个字符放到组合中去，接下来我们需要在剩下的n-1个字符中选取m-1个字符；
	 * 二是不把这个字符放到组合中去，接下来我们需要在剩下的n-1个字符中选择m个字符。这两种选择都很容易用递归实现。
	 */
	public static void combination(char[] t) {
		if (t == null || t.length == 0)
			return;
		Stack<Character> stack = new Stack<>();
		for (int m = 1; m <= t.length; m++) {
			combination(t, 0, m, stack);
		}
	}

	private static void combination(char[] t, int start, int m, Stack<Character> stack) {
		if(m == 0){
			System.out.println(stack.toString());
			return;
		}
		if(start == t.length){
			return;
		}
		//情况一
		stack.push(t[start]);
		combination(t, start+1, m-1, stack);
		
		//情况二
		stack.pop();
		combination(t, start+1, m, stack);
	}

}
