/**
 * 
 */
package stringandarray;

/**
 * 最长公共子序列
 * 
 * 如"abcda"和"adcba"；公共子序列为"aca"。
 * 
 * 提到回文串，自然要利用回文串的特点，想到将源字符串逆转后，“回文串”（不一定连续）相当于顺序没变
 * 求原字符串和其反串的最大公共子序列（不是子串，因为可以不连续）的长度（使用动态规划很容易求得），然后用原字符串的长度减去这个最大公共子串的长度就得到了最小编辑长度。
 */
public class LongestCommonSubsequence {

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		String str1 = "abcda";
		String str2 = "adcba";
		System.out.println(lcs(str1, str2));
	}

	public static int lcs(String str1, String str2){
		if(str1 == null || str2 == null)
			return 0;
		if(str1.length() == 0 || str2.length() == 0 || str1.length() != str2.length())
			return 0;
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		int n = c1.length;
		int[][] dp = new int[n+1][n+1];
		for(int i = 1;i<n+1;i++){
			for(int j = 1; j<n+1; j++){
				if(c1[i - 1] == c2[j - 1]){
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[n][n];
	}
}
