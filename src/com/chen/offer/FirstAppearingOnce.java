/**
 * 
 */
package com.chen.offer;

import java.util.Arrays;

/**
 * 字符流中第一个不重复的字符
 * 
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * 
 * 解决方案： 字符只能一个接着一个从字符流中读出来。可以定义一个数据容器来保存字符在字符流中的位置。
 * 当一个字符第一次从字符流中读出来时，把它在字符流中的位置保存到数据容器里。
 * 当这个字符再次从字符流中被读出来时，那么它就不是只出现一次的字符，也就可以被忽略了。 这时把它在数据容器里保存的值更新成一个特殊的值（比如负值）。
 * 为了尽可能高校地解决这个问题，需要在O(1)时间内往容器里插入一个字符，以及更新一个字符对应的值。
 * 这个容器可以用哈希表来实现。用字符的ASCII码作为哈希表的键值，而把字符对应的位置作为哈希表的值。
 */
public class FirstAppearingOnce {

	int[] charArr = new int[128];
	int index = 0;
	public FirstAppearingOnce(){
		Arrays.fill(charArr, -1);
	}
	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstAppearingOnce f = new FirstAppearingOnce();
	}

	/**
	 * 创建一个长度为128的数组charArr[]。用字符的ASCII码作为数组的下标，字符在字符流中的位置作为值。刚开始数组初始化为-1。若该字符未出现过，即charArr[ch]
	 * == -1，则令charArr[ch] = index(字符在字符流中的位置)，否则令charArr[ch] =
	 * -2。最后只要扫描整个数组，并从中找出最小的大于等于0的值对应的字符即可。
	 */

	/**
	 * Insert one char from stringstream TODO
	 * 
	 * @param c
	 *            void
	 */
	public void insert(char c) {
		if(charArr[c] == -1){
			charArr[c] = index;
		}else{
			charArr[c] = -2;
		}
		index++;
	}

	/**
	 * return the first appearence once char in current stringstream TODO
	 * 
	 * @return char
	 */
	public char firstAppearingOnce() {
		char c = '\0';
		int minIndex = Integer.MAX_VALUE;
		for(int i = 0;i<128;i++){
			if(charArr[i] >= 0 && charArr[i] < minIndex){
				c = (char)i;
				minIndex = charArr[i];
			}
		}
		return c == '\0' ? '#':c;
	}
}
