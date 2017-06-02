package stringandarray;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author tichen
 *
 *Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {

	public static void main(String[] args) {
		String s = "leetcode";
		Set<String> dict = new HashSet<>();
		dict.add("leet");
		dict.add("code");
		System.out.println(wordBreak2(s, dict));
	}
	
	//approach 1: naive,  is trivial
	public static boolean wordBreak(String s, Set<String> dict){
		return wordBreakHelper(s,dict,0);
	}

	private static boolean wordBreakHelper(String s, Set<String> dict, int start) {
		if(start == s.length())
			return true;
		
		for(String a: dict){
			int len = a.length();
			int end = start + len;
			
			if(end > s.length()){
				continue;
			}
			
			if(s.substring(start, start+len).equals(a)){
				if(wordBreakHelper(s, dict, start+len)){
					return true;
				}
			}
		}
		return false;
	}
	
	//这道题仍然是动态规划的题目，我们总结一下动态规划题目的基本思路。
	/**首先我们要决定要存储什么历史信息以及用什么数据结构来存储信息。
	 * 然后是最重要的递推式，就是如从存储的历史信息中得到当前步的结果。
	 * 最后我们需要考虑的就是起始条件的值。
	 */
	
	/**
	 * 接下来我们套用上面的思路来解这道题。首先我们要存储的历史信息res[i]是表示到字符串s的第i个元素为止能不能用字典中的词来表示，
	 * 我们需要一个长度为n的布尔数组来存储信息。然后假设我们现在拥有res[0,...,i-1]的结果，我们来获得res[i]的表达式。
	 * 思路是对于每个以i为结尾的子串，看看他是不是在字典里面以及他之前的元素对应的res[j]是不是true，如果都成立，那么res[i]为true
	 * 
	 * 假设总共有n个字符串，并且字典是用HashSet来维护，那么总共需要n次迭代，每次迭代需要一个取子串的O(i)操作，然后检测i个子串，而检测是constant操作。
	 * 所以总的时间复杂度是O(n^2)（i的累加仍然是n^2量级），而空间复杂度则是字符串的数量，即O(n)。
	 * @param s
	 * @param dict
	 * @return
	 */
	public static boolean wordBreak2(String s, Set<String> dict){
		boolean[] t = new boolean[s.length() + 1];
		t[0] = true;  //set first to be true, because we need initial state
		
		for(int i = 0; i<s.length(); i++){
			//should continue from match position
			if(!t[i])
				continue;
			for(String a: dict){
				int len = a.length();
				int end = i + len;
				if(end > s.length())
					continue;
				
				if(t[end])
					continue;
				
				if(s.substring(i, end).equals(a)){
					t[end] = true;
				}
			}
		}
		return t[s.length()];
	}

}
