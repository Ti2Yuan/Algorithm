package leetCode;

import java.io.UnsupportedEncodingException;

/**
 *编写一个截取字符串的函数
 *input a string and a number of bytes输入一个字符串和一个字节数
 *output a subString according to the number of bytes输出为按字节截取的字符串
 *guarantee that the Chinese character is not intercepted a half保证汉字不被截取半个
 *如"我ABC",4 ，截取为"我AB" ..."我ABC汉DEF"，6，截取"我ABC"，而不是"我ABC+半个汉" 
 * @author chenti
 *
 */

public class SubStringByByteNumber {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str="我a爱中华abc我爱创智def";
//		String str="我ABC汉";
		int num=trimGBK(str.getBytes("GBK"),4);
		System.out.println(str.substring(0, num));
	}

	private static int trimGBK(byte[] bytes, int n) {
		int num=0;
		boolean bChineseFirstHalf=false;
		for(int i=0;i<bytes.length;i++){
			System.out.print(bytes[i]+"  ");
		}
		System.out.println();
		for(int i=0;i<n;i++){
			if(bytes[i]<0 && !bChineseFirstHalf){
				bChineseFirstHalf=true;
			}else {
				num++;
				bChineseFirstHalf=false;
			}
		}
		return num;
	}

}
