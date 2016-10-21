package leetCode;

import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 字符和数字的排列组合问题
 * @author chenti
 *
 */
public class PermutationAndCombinationOfChar {

	public static void main(String[] args) {
		char[] initChars = new char[] { 'a', 'b', 'c'};
		int from = 0, target = 0;
//		permutationOfChar(initChars, from);
//		combinationOfChar(initChars);
		
		int n=4,k=2;
		combinationOfIntergers(n,k);
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

}
