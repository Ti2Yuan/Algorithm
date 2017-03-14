/**
 * 
 */
package stringandarray;

import java.util.HashMap;
import java.util.Map;

/**
 * 同构字符串
 * 
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * For example, Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * Note: You may assume both s and t have the same length.
 */
public class IsomorphicStrings {

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		String s = "egg";
		String t = "add";
		System.out.println(isIsomorphic(s, t));
	}
	
	/**
	 * We can define a map which tracks the char-char mappings. If a value is already mapped, it can not be mapped again.
	 * TODO
	 * @param s
	 * @param t
	 * @return
	 * boolean
	 */
	public static boolean isIsomorphic(String s, String t){
		if(s == null || t == null){
			return false;
		}
		if(s.length() != t.length())
			return false;
		Map<Character, Character> map = new HashMap<>();
		
		for(int i = 0,lenS = s.length();i<lenS;i++){
			char cs = s.charAt(i);
			char ct = t.charAt(i);
			
			if(map.containsKey(cs)){
				if(map.get(cs) != ct){  //如果map与t不匹配
					return false;
				}
			}else {
				if(map.containsValue(ct)){  //如果ct早已被匹配
					return false;
				}
				map.put(cs, ct);
			}
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
