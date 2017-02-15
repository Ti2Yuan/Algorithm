/**
 * 
 */
package leetcode;

import java.util.ArrayList;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING",3) should return "PAHNAPLSIIGYIR"
 * 
 * 观察规律后，以每行的元素作为轴，可以发现，下面的字母都是对称排列的 换成对应的index
 * 后，规律更明显
 * 0 4 8 1 3 5 7 9 2 6 _ 10
 * 第2层的元素就是以第一行的元素为轴，+1,-1 第三层的元素就是以第一行的元素为轴，+2,-2
 * …… 但是最后一层的元素，由于其特殊性，我们可以只考虑+k
 * Ps.所有过界的元素都不考虑
 * 轴也有规律：除了首尾两层，其他都是2个，所以第一层每隔2n-2出现一次。
 */
public class ZigZagConversion {

	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		System.out.println(convert(s, 3));
	}

	public static String convert(String s, int nRows){
		if(nRows <= 1 || s.length()< 2){
			return s;
		}
		ArrayList<StringBuilder> sbs = new ArrayList<StringBuilder>();
		for(int k = 0;k < nRows;k++){
			sbs.add(new StringBuilder());
		}
		int nCount = 2 * (nRows - 2) + 2;  //每次轴增加的步长
		//首尾只考虑+,不考虑-
		for(int i = 0;i < s.length();i++){
			sbs.get(nRows-1-Math.abs(nRows-1-(i % nCount))).append(s.charAt(i));
		}
		StringBuilder sb = new StringBuilder();
		for(int j = 0;j<nRows;j++){
			sb.append(sbs.get(j));
		}
		return sb.toString();
	}
}
