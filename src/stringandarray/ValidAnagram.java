/**
 * 
 */
package stringandarray;

/** 
 * Valid Anagram
 * 
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 * 
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car",
 * return false.
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 * 
 * Follow up: What if the inputs contain unicode characters? How would you adapt
 * your solution to such case?
 */
public class ValidAnagram {

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isAnagram(String s, String t){
		if(s == null || t == null){
			return false;
		}
		if(s.length() != t.length())
			return false;
		char[] cs = s.toCharArray();
		char[] ct = t.toCharArray();
		int[] flag = new int[256];
		for(int i = 0,lenS = cs.length;i<lenS;i++){
			flag[cs[i]]++;
		}
		for(int j = 0,lenT = ct.length;j<lenT;j++){
			char c = ct[j];
			if(flag[c] != 0){
				flag[c]--;
			}else {
				return false;
			}
		}
		for(int i = 0;i<256;i++){
			if(flag[i] != 0)
				return false;
		}
		return true;
	}

}
