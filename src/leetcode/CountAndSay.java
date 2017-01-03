/**
 * 
 */
package leetcode;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ... 1 is read off as "one 1" or 11. 11 is read off
 * as "two 1s" or 21. 21 is read off as "one 2, then one 1" or 1211. Given an
 * integer n, generate the nth sequence.
 */
public class CountAndSay {

	public static void main(String[] args) {
		int n = 7;
		System.out.println(countAndSay(n));
	}

	public static String countAndSay(int n) {
		if (n <= 0) {
			return null;
		}
		if (n == 1) {
			return "1";
		}
		String str = "1";
		StringBuilder resultStr = new StringBuilder();
		char currentValue = 0;
		char value;
		int count = 0;
		for (int i = 2; i <= n; i++) {
			value = str.charAt(0);
			for (int j = 0; j < str.length(); j++) {
				currentValue = str.charAt(j);
				if (currentValue == value) {
					count++;
				} else {
					resultStr.append(String.valueOf(count) + String.valueOf(value));
					value = currentValue;
					count = 1;
				}

			}
			resultStr.append(String.valueOf(count) + String.valueOf(value));
			currentValue = value;
			count = 0;
			str = resultStr.toString();
			resultStr = new StringBuilder();
		}
		return str.toString();
	}
}
