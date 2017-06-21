/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author chenti
 * 
 * Given two strings s and t, determine if they are isomorphic
 * Two strings are isomorphic if the characters in s can be replaced to get t
 * For example, "egg" and "add" are isomorphic, "foo" and "bar" are not.
 *
 */
public class IsomorphicStrings {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		String s = "add";
		String t = "foo";
		System.out.println(isIsomorphic(s, t));
	}
	
	public static boolean isIsomorphic(String s, String t){
		if(s == null || t == null){
			return false;
		}
		if(s.length() != t.length())
			return false;
		if(s.length() == 0 && t.length() == 0)
			return true;
		Map<Character, Character> map = new HashMap<>();
		for(int i = 0, len = s.length(); i<len; i++){
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			
			Character c = getKey(map, c2);
			if(c != null && c != c1){
				return false;
			}else if (map.containsKey(c)) {
				if(c2 != map.get(c))
					return false;
			}else {
				map.put(c1, c2);
			}
		}
		return true;
	}
	
	public static Character getKey(Map<Character, Character> map, Character c){
		if(map != null && map.size() > 0){
			Set<Entry<Character, Character>> valueSet = map.entrySet();
			for (Entry<Character, Character> entry : valueSet) {
				if(entry.getValue().equals(c)){
					return entry.getKey();
				}
			}
		}
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
