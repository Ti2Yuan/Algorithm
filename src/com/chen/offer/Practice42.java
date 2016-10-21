package com.chen.offer;

/**
 * 剑指offer第42题
 * 
 * 题目一：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理
 * 例如输入字符串"I am a student."，则输出"student. a am I"。
 * 
 * 题目一思路：第一步翻转句子中所有的字符，第二步再翻转每个单词中字符的顺序。
 * 
 * 题目二：把字符串分为两部分，要转移的为一部分，剩下的为另外一部分，先分别翻转这两部分
 * 接下来再翻转整个字符串
 * 
 * @author chenti
 *
 */
public class Practice42 {

	public static void main(String[] args) {
		Practice42 p = new Practice42();
		String str = "I am a student. you are";
		//题目一
		System.out.println(p.reverse(str));
	}

	
	
	
	
	//翻转字符串
	private void reverse2(char[] str){
		if(str == null || str.length == 0){
			return;
		}
		int length = str.length;
		int start = 0;
		int end = length-1;
		while(start<end){
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}
	
	
	
	//采用字符串的split方法
	private String reverse(String str) {
		String[] subStr = str.split(" ");
		if(subStr == null || subStr.length == 1)
			return str;
		int length = subStr.length;
		int mid = (length - 1)/2;
		for(int i=0;i<mid;i++){
			String temp = subStr[i];
			subStr[i] = subStr[length-1-i];
			subStr[length-1-i] = temp;
			System.out.print(subStr[i]+"  "+subStr[length-1-i]);
			System.out.println();
		}
		if(mid%2 == 0){
			String temp = subStr[mid];
			subStr[mid] = subStr[mid+1];
			subStr[mid+1] = temp;
			System.out.print(subStr[mid]+"  "+subStr[mid+1]);
			System.out.println();
		}
		StringBuilder sb = new StringBuilder();
		for(String s:subStr){
			sb.append(s+" ");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

}
