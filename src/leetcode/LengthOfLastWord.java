/**
 * 
 */
package leetcode;

/**
 * Length of Last Word 
 * Given a string s consists of upper/lower-case alphabets
 * and empty space characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 */
public class LengthOfLastWord {

	public static void main(String[] args) {
		String s = "Hello World";
		System.out.println(lengthOfLastWord2(s));
	}

	//倒着找，注意字符串最后是空格的情况
	public static int lengthOfLastWord(String s) {
		if(s == null || s.trim().equals(""))
			return 0;
		int length = s.length();
		while(s.charAt(length-1) == ' '){
			length--;
		}
		int l = length;
		while((length-1)>=0 && s.charAt(length-1) != ' '){
			length--;
		}
		return l - length;
	}
	
	//运用spilt的方法
	public static int lengthOfLastWord2(String s){
		if(s == null || s.length() == 0 || s.trim().equals("")){
			return 0;
		}
		String[] subString = s.split(" ");
		return subString[subString.length-1].length();
	}
}
