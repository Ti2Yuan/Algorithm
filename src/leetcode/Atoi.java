/**
 * 
 */
package leetcode;

/**
 * Implement atoi to convert a string to an integer. Hint: Carefully consider
 * all possible input cases. If you want a challenge, please do not see below
 * and ask yourself what are the possible input cases.
 * 
 * Keys: Whitespaces, Additional chars, Signs, Out of range
 * 
 * Requirements for atoi: The function first discards as many whitespace
 * characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus
 * sign followed by as many numerical digits as possible, and interprets them as
 * a numerical value.
 * 
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned. If the
 * correct value is out of the range of representable values, INT_MAX
 * (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 * Tags: Math, String
 */
public class Atoi {

	
	public static void main(String[] args){
		System.out.println("MAX_VALUE: "+Integer.MAX_VALUE);
		System.out.println("MIN_VALUE: "+Integer.MIN_VALUE);
		System.out.println("2147483648: "+atoi2("2147483648"));
		System.out.println("-2147483647: "+atoi2("-2147483647"));
		System.out.println("-2147483648: "+atoi2("-2147483648"));
	}

	/**
	 * Whitespace, sign, out of range.
	 * Trim the unnecessary whitespace.
	 * initialize a variable as long to store the result.
	 * use a boolean as a flag to mark whether it's negative
	 * return MAX or MIN if it's out of range
	 * TODO
	 * @param str
	 * @return
	 * String
	 */
	private static int atoi(String str) {
		//validate input
		if(str == null || str.length() == 0){
			return 0;
		}
		long result = 0; //result can be out of range.
		str = str.trim(); //remove front and trailing whitespace.
		boolean neg = false;
		if(str.charAt(0) == '-'){
			neg = true;
			str = str.substring(1, str.length());
		}else if(str.charAt(0) == '+'){
			str = str.substring(1, str.length());
		}
		/* calculation */
		int i = 0;
		while(i < str.length()){
			char c = str.charAt(i);
			if(c >= '0' && c <= '9'){
				result = result * 10 + (c - '0');
			}else {
				break;
			}
			i++;
		}
		result = neg ? result*(-1):result;  // add sign
		/* out of range */
		if(result > Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}else if (result < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return (int)result;
	}
	
	/**
	 * To deal with overflow, inspect the current number before multiplication.
	 * If the current number is greater than 214748364, we know it is going to 
	 * overflow. On the other hand, if the current number is equal to 214748364, 
	 * we know that it will overflow only when the current digit is greater than or equal to 8.
	 */
	private static final int maxDiv10 = Integer.MAX_VALUE / 10;
	
	public static int atoi2(String str){
		int n = str.length();
		int i = 0;
		while(i < n && Character.isWhitespace(str.charAt(i)))
			i++;
		int sign = 1;
		if(i < n && str.charAt(i) == '+'){
			i++;
		}else if (i < n && str.charAt(i) == '-') {
			sign = -1;
			i++;
		}
		int num = 0;
		while(i < n && Character.isDigit(str.charAt(i))){
			int digit = Character.getNumericValue(str.charAt(i));
			if(num > maxDiv10 || num == maxDiv10 && digit >= 8){
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			num = num * 10 + digit;
			i++;
		}
		return sign * num;
	}
	
}
