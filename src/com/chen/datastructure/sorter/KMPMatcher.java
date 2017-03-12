/**
 * 
 */
package com.chen.datastructure.sorter;

/**
 *
 */
public class KMPMatcher {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcddefgdehj";
		String s1 = "deh";
		char[] str = s.toCharArray();
		char[] pattern = s1.toCharArray();
		System.out.println(kmpMatching(str, pattern));
	}
	
	public static int[] getNext(char[] pattern){
		if(pattern == null || pattern.length <= 0)
			return null;
		int i = 0;
		int k = -1;
		int[] next = new int[pattern.length];
		next[0] = -1;
		while(i < pattern.length - 1){
			if( k == -1 || pattern[i] == pattern[k]){
				i++;
				k++;
				next[i] = k;
			}
			else {
				k = next[k];
			}
		}
		return next;
	}
	
	public static int kmpMatching(char[] str, char[] pattern){
		if(str == null || pattern == null)
			return -1;
		int i = 0;
		int j = 0;
		int[] next = getNext(pattern);
		if(next == null)
			return -1;
		while(i < str.length && j<pattern.length){
			if( j == -1 || str[i] == pattern[j]){
				i++;
				j++;
			}else {
				j = next[j];
			}
		}
		if(j == pattern.length){
			return i-j;
		}
		return -1;
	}

}
