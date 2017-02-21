/**
 * 
 */
package com.chen.offer;

/**
 * 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 
 * 解题思路： 在数值之前可能有一个表示正负的’-‘或者’+’。接下来是若干个0到9的数位表示数值的整数部分（在某些小数里可能没有数值的整数部分）。
 * 如果数值是一个小数，那么在小数点后面可能会有若干个0到9的数位表示数值的小数部分。
 * 如果数值用科学计数法表示，接下来是一个’e’或者‘E’，以及紧跟着的一个整数（可以有正负号）表示指数。
 * 判断一个字符串是否符合上述模式时，首先看第一个字符是不是正负号。 如果是，在字符串上移动一个字符，继续扫描剩余的字符串中0到9的数位。
 * 如果是一个小数，则将遇到小数点。另外，如果是用科学计数法表示的数值，在整数或者小数的后面还有可能遇到’e’或者’E’。
 */
public class IsNumericString {

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "+054";
		char[] str = string.toCharArray();
		System.out.println(isNumeric(str));
	}

	/**
	 * 这题条件有点多，从最后的测试用例可以知道 "600."这种形式是算true的 
	 * 具体的条件是： 非空判断
	 * 1，先判断符号位，当前索引后移，检查是否只有符号 
	 * 2，符号位后是不是纯数字，跳过纯数字，对第一个非数字进行判断
	 * A，数字后是小数点“.”，索引后移，判断小数点后面的数
	 * -------------此时情况太多---------------------------------------------- 
	 *        a，小数点后是指数字母E/e 
	 *        b，小数点后是其他非数字的字母 
	 *        c，小数点后是数字，跳过数字，对数字后面进行判断 
	 *            c1，数字后是E/e，
	 *            c2,数字后是其他 
	 * B，数字后是指数字母E/e 
	 * C，数字后是其他字符 
	 * 至此情况完毕，其中每次索引后移后先判断是否到达末尾。 
	 * TODO
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isNumeric(char[] str) {
		
		//利用正则表达式
			//String string = String.valueOf(str);
			//return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
		/**
		 * 几个关键点：
		 * 1. 基本边界
		 * 2. 检测是否有符号位
		 * 3. 检测除符号位外的第一个有效位，有效位只能是数字或小数点
		 * 4. 检测是否有E或e，且不能重复出现
		 * 5. 小数点不能重复出现
		 * 6. 数字的合法性，不能是其他字母如'a'等。
		 */
		if(str == null || str.length == 0)
			return false;
		int index = 0;
		if(str[index] == '+' || str[index] == '-')
			index++;
		if(index >= str.length) //只有符号，肯定不是数值
			return false;
		while(index < str.length){
			if(isNum(str[index])){
				index++;
			}else {
				break;
			}
		}
		//符号后面的数字都跳过，此时index处不是数字
		if(index < str.length){
			if(str[index] == '.'){  //1.小数点
				index++;
				if(index >= str.length)  // a.只有小数点
					return true;
				if(str[index] == 'e' || str[index] == 'E'){ //小数点后是字母E或e
					return false;
				}
				if(!isNum(str[index]))  //小数点后不是数字
					return false;
				while(index < str.length){
					if(!isNum(str[index]))
						break;
					index++;
				}
				if(index >= str.length) //小数点后是纯数字
					return true;
				else if (str[index] == 'e' || str[index] == 'E') {
					return isExpon(str,index);
				}else {
					return false;
				}
			}else if (str[index] == 'e' || str[index] == 'E') {  //2.指数
				return isExpon(str, index);
			}else {   //其他字母
				return false;  
			}
		}
		return true;
	}
	
	public static boolean isNum(char c){
		if(c >= '0' && c<='9'){
			return true;
		}
		return false;
	}
	
	public static boolean isExpon(char[] str,int index){
		if(str[index] != 'e' && str[index] != 'E')
			return false;
		index++;
		//e/E的后面有符号
		if(index < str.length && (str[index] == '+' || str[index] == '-'))
			index++;
		//后面必须接数字
		if(index >= str.length)
			return false;
		while(index < str.length){
			if(!isNum(str[index]))
				break;
			index++;
		}
		return index == str.length?true:false;
	}
	
	
	
	
	
	
	
	
	
	
	
}
