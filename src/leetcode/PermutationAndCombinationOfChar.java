package leetcode;

import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 字符串的组合和排列 
 * 
 * 组合： 假设我们想在长度为n的字符串中求m个字符的组合。我们先从头扫描字符串的第一个字符。
 * 针对第一个字符，我们有两种选择：第一是把这个字符放到组合中去，接下来我们需要在剩下的n-1个字符中选取m-1个字符；
 * 第二是不把这个字符放到组合中去，接下来我们需要在剩下的n-1个字符中选择m个字符。这两种选择都很容易用递归实现
 *
 */
public class PermutationAndCombinationOfChar {

	public static void main(String[] args) {
		char[] initChars = new char[] { 'a', 'b', 'c'};
		int from = 0, target = 0;
		//permutationOfChar(initChars, from);
		//combinationOfChar(initChars);
		permutation(initChars);
		combination(initChars);
		int n=4,k=2;
//		combinationOfIntergers(n,k);
	}

	/**
	 *Given two integers n and k,return all possible combinations of k numbers out
	 *of 1....n. For example,if n=4,k=2,a solution is:
	 *
	 *[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]] 
	 */
	private static ArrayList<ArrayList<Integer>> combinationOfIntergers(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> subset = new ArrayList<>();
		int[] num = new int[n];
		for(int j=0;j<n;j++){
			num[j] = j+1;
		}
		subsets(n,k,num,0,subset,result);
		System.out.println(result);
		return result;
	}


	private static void subsets(int n, int k, int[] num, int begin,ArrayList<Integer> subset,
			ArrayList<ArrayList<Integer>> result) {
		if(subset.size()>=k){
			ArrayList<Integer> c = new ArrayList<>(subset);
			result.add(c);
		}else {
			for(int i=begin;i<n;i++){
				subset.add(num[i]);
				subsets(n, k, num, i+1, subset, result);
				subset.remove(subset.size()-1);
			}
		}
	}

	private static void combinationOfChar(char[] initChars) {
		int length = initChars.length;
		int n = 1 << length;
		for(int i=0;i<n;i++){
			StringBuilder sb=new StringBuilder();
			for(int j=0;j<length;j++){
				if((i & 1<<j)!=0){
					sb.append(initChars[j]);
				}
			}
			System.out.println(sb.toString());
		}

	}


	private static void permutationOfChar(char[] initChars, int from) {
		if (from == initChars.length) {
			for (char s : initChars) {
				System.out.print(s);
			}
			System.out.println();
		}
		for (int i = from; i < initChars.length; i++) {
			swap(initChars, from, i);
			permutationOfChar(initChars, from+1);
			swap(initChars, i,from);
		}
	}

	private static void swap(char[] initChars, int from, int target) {
		char temp = initChars[from];
		initChars[from] = initChars[target];
		initChars[target] = temp;
	}

	/**
	 * 字符串的排列（分治思想）
	 * @param t
	 */
	public static void permutation(char[] t){
		if(t == null || t.length == 0){
			return;
		}
		permutation(t, 0, t.length - 1);
	}

	private static void permutation(char[] t, int start, int end) {
		if(start > end){
			System.out.println(Arrays.toString(t));
		}else{
			for(int i = start; i <= end; i++){
				swap(t, start, i);
				permutation(t, start+1, end);
				swap(t, i, start);
			}
		}
	}

	/**
	 * 字符串的组合
	 * @param t
	 */
	private static void combination(char[] t){
		if(t == null  || t.length == 0){
			return;
		}
		Stack<Character> stack = new Stack<>();
		for(int i = 1; i<=t.length; ++i){
			combination(t, 0, i, stack);
		}
	}

	private static void combination(char[] t, int start, int m, Stack<Character> stack) {
		if(m == 0){
			System.out.println(stack.toString());
			return;
		}
		if(start == t.length)
			return;
		stack.push(t[start]);
		combination(t, start+1, m-1, stack);
		stack.pop();
		combination(t, start+1, m, stack);
	}
}
