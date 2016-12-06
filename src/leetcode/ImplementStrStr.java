package leetcode;

/**
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * �����㷨�бȽϾ�������⣬�ж�һ���ַ����Ƿ�����һ���ַ������Ӵ��������Ŀ�����㷨Ӧ����KMP�㷨����
 * KMP�㷨�����ŵ������㷨�����Ӷ��Ѿ��ﵽ�����������ޡ�����KMP�㷨�Ƚϸ��ӣ����������ԵĶ�ʱ������������ȷ��ʵ�֡�����һ���������в���Ҫ��ʵ��KMP�㷨��
 */
public class ImplementStrStr {

	public static void main(String[] args) {

		String haystack = "abcssdjejfsljej";
		String needle = "jej";
		int index = strStr(haystack, needle);
		System.out.println(index);
		System.out.println(strStrByKMP(haystack, needle));
	}

	/**
	 * brute force method ʱ�临�Ӷȣ� O((n-m+1) * m) = O(n*m) �ռ临�Ӷȣ�O(1)
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return -1;
		int n = haystack.length();
		int m = needle.length();
		for (int i = 0; i < n - m + 1; i++) {
			int j;
			for (j = 0; j < m; j++) {
				if (haystack.charAt(i + j) != needle.charAt(j))
					break;
			}
			if (j == m) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * KMP algorithm
	 */
	public static int strStrByKMP(String haystack, String needle) {
		if (haystack == null || needle == null)
			return -1;
		int[] next = getNext(needle);
		int i = 0;
		int j = 0;
		int len1 = haystack.length();
		int len2 = needle.length();
		while (i < len1 && j < len2) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else if(next[j] == -1){
				i++;
				j = 0;
			}else {
				j = next[j];
			}
		}
		if (i < len1) {
			return i - len2;
		}
		return -1;

	}

	public static int[] getNext(String needle) {
		int len = needle.length();
		int[] next = new int[len];
		int j = 0;
		int k = -1;
		next[j] = k;
		while (j < len - 1) {
			if (k == -1 || needle.charAt(j) == needle.charAt(k)) {
				j++;
				k++;
				next[j] = k;
			} else {
				k = next[k];
			}
		}
		return next;

	}
}
