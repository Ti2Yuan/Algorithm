/**
 * 
 */
package stringandarray;

import java.util.Scanner;

/**
*给定一个字符串，请你将字符串重新编码，将连续的字符替换成“连续出现的个数+字符”。比如字符串AAAABCCDAA会被编码成4A1B2C1D2A。 
输入描述:
每个测试输入包含1个测试用例
每个测试用例输入只有一行字符串，字符串只包括大写英文字母，长度不超过10000。


输出描述:
输出编码后的字符串

输入例子:
AAAABCCDAA

输出例子:
4A1B2C1D2A
 */
public class StringCoder {

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(transferString());
	}

	public static String transferString() {
		StringBuilder sb = new StringBuilder();
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		if (string == null || string.length() <= 0)
			return sb.toString();
		char[] cs = string.toCharArray();
		int len = cs.length;
		char currentChar = cs[0];
		int count = 1;
		for (int i = 1; i < len; i++) {
			if (currentChar != cs[i]) {
				sb.append(count);
				sb.append(currentChar);
				currentChar = cs[i];
				count=1;
			}else {
				count++;
			}
		}
		sb.append(count);
		sb.append(currentChar);
		return sb.toString();
	}

}
