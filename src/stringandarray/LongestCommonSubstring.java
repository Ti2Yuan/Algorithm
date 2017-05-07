/**
 * 
 */
package stringandarray;

/**
 *最长公共子串
 *
 *其实这是一个序贯决策问题，可以用动态规划来求解。我们采用一个二维矩阵来记录中间的结果。这个二维矩阵怎么构造呢？直接举个例子吧："bab"和"caba"(当然我们现在一眼就可以看出来最长公共子串是"ba"或"ab")

　　 b　　a　　b

c　　0　　0　　0

a　　0　　1　　0

b　　1　　0　　1

a　　0　　1　　0

我们看矩阵的斜对角线最长的那个就能找出最长公共子串。

不过在二维矩阵上找最长的由1组成的斜对角线也是件麻烦费时的事，下面改进：当要在矩阵是填1时让它等于其左上角元素加1。

　　 b　　a　　b

c　　0　　0　　0

a　　0　　1　　0

b　　1　　0　　2

a　　0　　2　　0

这样矩阵中的最大元素就是 最长公共子串的长度。

在构造这个二维矩阵的过程中由于得出矩阵的某一行后其上一行就没用了，所以实际上在程序中可以用一维数组来代替这个矩阵。
 */
public class LongestCommonSubstring {

	public static void main(String[] args) {
		String str1 = "123456abcd567";
		String str2 = "234dddabc45678";
		getLCString(str1.toCharArray(), str2.toCharArray());
	}

	public static void getLCString(char[] str1, char[] str2){
		if(str1 == null || str2 == null || str1.length <= 0 || str2.length <= 0)
			return;
		int i,j;
		int len1,len2;
		len1 = str1.length;
		len2 = str2.length;
		int maxLen = len1 > len2 ? len1:len2;
		int[] max = new int[maxLen];
		int[] maxIndex = new int[maxLen];
		int[] c = new int[maxLen];    //记录对角线上的相等值的个数
		
		for(i = 0; i<len2; i++){
			for(j = len1 - 1; j>=0; j--){
				if(str2[i] == str1[j]){
					if((i == 0) || (j == 0)){
						c[j] = 1;
					}else {
						c[j] = c[j - 1] + 1;
					}
				}else {
					c[j] = 0;
				}
				
				//如果是大于，那暂时只有一个是最长的，而且要把后面的清0
				if(c[j] > max[0]){
					max[0] = c[j];     //记录对角线元素的最大值，之后在遍历时用作提取子串的长度
					maxIndex[0] = j;  //记录对角线元素最大值的位置
					
					for(int k = 1; k<maxLen; k++){
						max[k] = 0;
						maxIndex[k] = 0;
					}
				}else if (c[j] == max[0]) {       //有多个是相同长度的子串
					for(int k = 1; k<maxLen; k++){
						if(max[k] == 0){
							max[k] = c[j];
							maxIndex[k] = j;
							break;  //加一个之后就要退出循环
						}
					}
				}
			}
		}
		
		for(j = 0; j<maxLen; j++){
			if(max[j] > 0){
				System.out.println("第" + (j+1) + "个公共子串");
				for(i = maxIndex[j] - max[j] + 1; i <= maxIndex[j]; i++){
					System.out.print(str1[i]);
				}
				System.out.println();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
