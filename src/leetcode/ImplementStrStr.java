package leetcode;

/**
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 这是算法中比较经典的问题，判断一个字符串是否是另一个字符串的子串。这个题目最经典的算法应该是KMP算法。、
 * KMP算法是最优的线性算法，复杂度已经达到这个问题的下限。但是KMP算法比较复杂，很难在面试的短时间里面完整正确的实现。所以一般在面试中并不要求实现KMP算法。
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
	 * brute force method 时间复杂度： O((n-m+1) * m) = O(n*m) 空间复杂度：O(1)
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
