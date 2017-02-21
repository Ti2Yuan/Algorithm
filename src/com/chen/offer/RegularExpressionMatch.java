/**
 * 
 */
package com.chen.offer;

/**
 * 正则表达式匹配
 * 
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * 
 */
public class RegularExpressionMatch {

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "bcbbabab";
		String pattern = ".*a*a";  //"ab*ac*a"
		char[] str1 = str.toCharArray();
		char[] pattern1 = pattern.toCharArray();
		System.out.println(match(str1, pattern1));
	}

	/**
	 * 递归实现 
	 * 每次分别在str 和pattern中取一个字符进行匹配，如果匹配，则匹配下一个字符，否则，返回不匹配。 设匹配递归函数match(str, pattern)。
	 * 如果模式匹配字符的下一个字符是‘*’:
	 * 如果pttern当前字符和str的当前字符匹配，：有以下三种可能情况 
	 * （1）pttern当前字符能匹配 str 中的 0个字符：match(str, pattern+2) 
	 * （2）pttern当前字符能匹配 str 中的 1 个字符：match(str+1,pattern+2) 
	 * （3）pttern当前字符能匹配 str 中的 多 个字符：match(str+1, pattern)
	 * 如果pttern当前字符和和str的当前字符不匹配  pttern当前字符能匹配 str 中的 0 个字符：(str, pattern+2)
	 * 如果模式匹配字符的下一个字符不是‘*’，进行逐字符匹配。
	 *  对于 ‘.’ 的情况比较简单，’.’ 和一个字符匹配 match(str+1,pattern+1) 另外需要注意的是：空字符串”” 和 “.*” 是匹配的
	 *   
	 *  TODO
	 * @param str
	 * @param pattern
	 * @return boolean
	 */
	public static boolean match(char[] str, char[] pattern) {
		if(str == null || pattern == null)
			return false;
		return match(str, 0, pattern, 0);
	}
	
	public static boolean match(char[] str,int indexStr, char[] pattern, int indexPat){
		//两者都到了最后，说明已经完全匹配
		if(indexStr >= str.length && indexPat >= pattern.length){
			return true;
		}
		//模式完了，字符串还有
		if(indexStr < str.length && indexPat >= pattern.length)
			return false;
		
		//考虑pattern中包含"*"的情况
		if(indexPat < pattern.length - 1 && pattern[indexPat+1] == '*'){
			if(indexStr < str.length && (str[indexStr] == pattern[indexPat] || pattern[indexPat] == '.')){
				return match(str, indexStr, pattern, indexPat+2) || match(str, indexStr+1, pattern, indexPat+2) || match(str, indexStr+1, pattern, indexPat);
			}else {
				//indexStr到了末尾，但是indexPat没达到末尾，另外，对于str中的a，可能pattern中跟的是b*
				return match(str, indexStr, pattern, indexPat+2);
			}
		}
		
		//当前pattern的下一个不是*
		if(indexStr >= str.length){
			return false;
		}
		
		if(str[indexStr] == pattern[indexPat] || pattern[indexPat] == '.'){
			return match(str, indexStr+1, pattern, indexPat+1);
		}
		
		return false;
	}
}








