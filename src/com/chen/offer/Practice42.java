package com.chen.offer;

/**
 * ��ָoffer��42��
 * 
 * ��Ŀһ������һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䡣Ϊ������������ź���ͨ��ĸһ������
 * ���������ַ���"I am a student."�������"student. a am I"��
 * 
 * ��Ŀһ˼·����һ����ת���������е��ַ����ڶ����ٷ�תÿ���������ַ���˳��
 * 
 * ��Ŀ�������ַ�����Ϊ�����֣�Ҫת�Ƶ�Ϊһ���֣�ʣ�µ�Ϊ����һ���֣��ȷֱ�ת��������
 * �������ٷ�ת�����ַ���
 * 
 * @author chenti
 *
 */
public class Practice42 {

	public static void main(String[] args) {
		Practice42 p = new Practice42();
		String str = "I am a student. you are";
		//��Ŀһ
		System.out.println(p.reverse(str));
	}

	
	
	
	
	//��ת�ַ���
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
	
	
	
	//�����ַ�����split����
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
