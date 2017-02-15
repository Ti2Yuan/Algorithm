package leetcode;

import java.util.Arrays;

/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations. 
 * By listing and labeling all of the permutations in order.
 * We get the following sequence (ie, for n=3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the k-th permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 */
public class PermutationSequence {

	public static void main(String[] args) {
		String s = "123";
//		String s1 = swap(s, 1, 2);
//		System.out.println(nextPermutation("132"));
		System.out.println(getPermutation2(3, 6));
	}
	
	//solution 2:directly to the k-th permutation
	//example: n=4,k=9
	//1234,1243,1324,1342,1423,1432,2134,2143,2314(k),2341,2413,2431,3124,3142,3214,3241,3412,3421,
	//4123,4132,4213,4231,4312,4321
	//���λ����ȡ{1,2,3,4},��ÿ�����ظ�3! = 6�Ρ����Ե�k=9�� permutation��s[0]Ϊ{1��2��3��4}�еĵ�9/6+1 = 2�����֣���Ϊ2.
	//������2��ͷ��6�����ֶ��ԣ�k = 9�����еĵ�9%6=3������ʣ�µ�{1,3,4}�У�ȡ����һ������ʣ�µ��ظ�����Ϊ2��=2�Ρ�
	//����s[1]=3/2+1=2������Ϊ��2������3.
	//������23��ͷ��2�����ֶ��ԣ�k=9�����е�3%2=1����ʣ�µ�����{1,4}��ȡ����һ������ʣ�µ��ظ�����Ϊ1��=1�Ρ�����s[2]=1��
	//������231��ͷ��1�����ֶ��ԣ�k=9�����еĵ�1%1=0��������s[3]=0/1+1=1��������һ������4.
	public static String getPermutation(int n,int k){
        StringBuilder sb = new StringBuilder();
        
		if(n <= 0 || k <= 0 )
			return sb.toString();
		int value;
		
		return sb.toString();
	}
	
	//solution 1: nextPermutation method(time out)
	public static String getPermutation2(int n,int k){
		String result = null;
		StringBuilder sb = new StringBuilder();
		for(int i = 1;i<=n;i++){
			sb.append(i);
		}
		String initStr = sb.toString();
		String lastStr = sb.toString();
		int i;
		for(i = 1;i<k;i++){
			initStr = nextPermutation(lastStr);
			if(initStr.equals(lastStr)){
				break;
			}
			lastStr = initStr;
		}
		if(i<k){
			return result;
		}
		result = initStr;
		return result;
	}
	
	public static String nextPermutation(String s){
		if(s == null || s.length() == 0){
			return null;
		}
		int length = s.length();
		char c = s.charAt(length-1);
		for(int i = length-2;i>=0;i--){
			if(s.charAt(i)<c){
				for(int j = length-1;j>i;j--){
					if(s.charAt(j)>s.charAt(i)){
						s = swap(s,i,j);
						s = sort(s,i+1);
						break;
					}
				}
				break;
			}
			c = s.charAt(i);
		}
		return s;
	}

	/**
	 * sort string s from index i in ascending order
	 * @param s
	 * @param i
	 */
	private static String sort(String s, int i) {
		char[] c = s.toCharArray();
		Arrays.sort(c, i, c.length);
		String str = new String(c);
		return str;
	}

	/**
	 * swap two elements of string s
	 * @param s string needed to be changed
	 * @param i index be replaced by j
	 * @param j index be replaced by i
	 * @return a string after replace
	 */
	private static String swap(String s, int i, int j) {
		char temp = s.charAt(i);
		char[] c = s.toCharArray();
		c[i] = c[j];
		c[j] = temp;
		String s1 = new String(c);
		return s1;
	}

}
