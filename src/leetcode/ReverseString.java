/**
 * 
 */
package leetcode;

import java.io.UnsupportedEncodingException;

/**
 * 反转字符串
 */
public class ReverseString {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "chenti hello!";
		System.out.println(reverseString(str));
		System.out.println(reverseWords(str));
		
		//怎样将GB2312编码的字符串转换为ISO-8859-1编码的字符串？
		String s1 = "你好";
		try {
			String s2 = new String(s1.getBytes("GB2312"), "ISO-8859-1");
			System.out.println(s2);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 递归方法反转字符串
	 * TODO
	 * @param str
	 * @return
	 * String
	 */
	public static String reverseString(String str){
		if(str == null || str.length() <= 1)
			return str;
		return reverseString(str.substring(1)) + str.charAt(0);
	}
	
	
	public static String reverseWords(String str){
	    String result = null;
	    if(str == null || str.length() == 0){
	        return result;
	    }
	    String[] words = str.split(" ");
	    int len = words.length;
	    for(int i = 0;i<len/2;i++){
	        String temp = words[i];
	        words[i] = words[len-1-i];
	        words[len-1-i] = temp;
	    }
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0;i<len;i++){
	        sb.append(words[i]+" ");
	    }
	    return sb.toString().substring(0,sb.length()-1);
	}

}
