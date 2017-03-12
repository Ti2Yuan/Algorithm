/**
 * 
 */
package stringandarray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 */
public class LongestSubtstringWithoutRepeat {

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		String str = "abcabcbb";
		System.out.println(lengthOfLongestSubstring2(str));
	}

	/**
	 * Java Solution 1
     * The first solution is like the problem of "determine if a string has all unique characters". 
     * We can use a flag array to track the existing characters for the longest substring without repeating characters.
     * 
	 * TODO
	 * @param str
	 * @return
	 * int
	 */
	public static int lengthOfLongestSubstring(String str){
		if(str == null || str.length() <= 0)
			return 0;
		char[] cs = str.toCharArray();
		boolean[] flag = new boolean[256];
		Arrays.fill(flag, false);
		int begin = 0;  //position where substring begins
		int maxLength = 0;  
		int currentLength = 0;
		int i = 0;
		for(int len = cs.length; i<len; i++){
			char pos = cs[i];
			if(flag[pos]){         //if the char is in the substring
				currentLength = i - begin;
				maxLength = Math.max(currentLength, maxLength);
				for(int j = begin; j < i; j++){
					if(cs[j] == pos){
						begin = j + 1;
						break;
					}
					flag[cs[j]] = false;
				}
			}
			else {
				flag[pos] = true;
			}
		}
		//最后一趟没计算
		int x = 0;
		return maxLength > (x = i-begin) ? maxLength:x;
	}
	
	/**
	 * method 2: HashSet
	 * TODO
	 * @param str
	 * @return
	 * int
	 */
	public static int lengthOfLongestSubstring2(String str){
		if(str == null || str.length() <= 0)
			return 0;
		Set<Character> cSet = new HashSet<>();
		char[] cs = str.toCharArray();
		int currentLength = 0;
		int maxLength = 0;
		int begin = 0;
		int i = 0;
		for(int len = cs.length;i<len;i++){
			if(cSet.contains(cs[i])){
				currentLength = i - begin;
				maxLength = Math.max(currentLength, maxLength);
				for(int j = begin;j<i;j++){
					if(cs[j] == cs[i]){
						cSet.remove(cs[j]);
						begin = j+1;
						break;
					}
					cSet.remove(cs[j]);
				}
			}
			//不论set中包括不包括，都应执行下列语句
			cSet.add(cs[i]);
		}
		int k = i - begin;
		return maxLength > k ? maxLength : k; 
	}
	
	
	
	
	
	
	
	
	
	
	
}
