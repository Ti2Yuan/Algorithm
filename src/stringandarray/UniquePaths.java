/**
 * 
 */
package stringandarray;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * 
 * Note: m and n will be at most 100.
 */
public class UniquePaths {

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		int m = 3;
		int n = 7;
		System.out.println(uniquePaths(m, n));
		System.out.println(uniquePaths2(m, n));
	}
	
	/**
	 * DFS
	 * A depth-first search solution is pretty straight-forward. 
	 * However, the time of this solution is too expensive, and it didn't pass the online judge.
	 * 存在重复计算，leetcode跑会超时
	 * TODO
	 * @param m
	 * @param n
	 * @return
	 * int
	 */
	public static int uniquePaths(int m, int n){
		int currX = 0;
		int currY = 0;
		int count = 0;
		count = dfs(currX,currY,m-1,n-1);
		return count;
	}
	
	public static int dfs(int currX, int currY, int targetX, int targetY){
		if(currX > targetX || currY > targetY)
			return 0;
		
		if(currX == targetX && currY == targetY){
			return 1;
		}

		//right
		int rightCount = dfs(currX, currY+1, targetX, targetY);
		
		//down
		int downCount = dfs(currX+1, currY, targetX, targetY);
		
		return rightCount + downCount;
	}
	
	/**
	 * Dynamic programming
	 * sum[x][y] = sum[x+1][y] + sum[x][y+1]
	 * 先置最后一行和最后一列为1，然后在动态规划计算
	 * TODO
	 * @param m
	 * @param n
	 * @return
	 * int
	 */
    public static int uniquePaths2(int m, int n){
		if(m == 0 || n == 0)
			return 1;
		int[][] sum = new int[m][n];
		for(int i = 0;i<m;i++){
			sum[i][n-1] = 1;
		}
		for(int j = 0;j<n;j++){
			sum[m-1][j] = 1;
		}
//		sum[m-2][n-1] = 1;
//		sum[m-1][n-2] = 1;
		for(int i = m-2;i>=0;i--){
			for(int j=n-2;j>=0;j--){
				sum[i][j] = sum[i+1][j] + sum[i][j+1];
			}
		}
		return sum[0][0];
	}

    
    
    
    
    
    
    
    
}
