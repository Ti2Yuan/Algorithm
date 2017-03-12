/**
 * 
 */
package stringandarray;

/**
 * Minimum Path Sum
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * 和Unique Paths相似，可利用动态规划，也可利用深度遍历
 */
public class MinimumPathSum {

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 利用动态规划的方法求解
	 * TODO
	 * @param grid
	 * @return
	 * int
	 */
	public static int minPathSum(int[][] grid){
		if(grid == null || grid.length <= 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		int[][] minSum = new int[m][n];
		minSum[m-1][n-1] = grid[m-1][n-1];
		//初始化最后一列
		for(int i = m-2;i>=0;i--){
			minSum[i][n-1] = minSum[i+1][n-1] + grid[i][n-1]; 
		}
		//初始化最后一行
		for(int j = n-2;j>=0;j--){
			minSum[m-1][j] += minSum[m-1][j+1] + grid[m-1][j];
		}
		for(int i = m-2;i>=0;i--){
			for(int j=n-2;j>=0;j--){
				minSum[i][j] = grid[i][j] + (minSum[i+1][j] > minSum[i][j+1] ? minSum[i][j+1] : minSum[i+1][j]);
			}
		}
		return minSum[0][0];
	}
	
	/**
	 * Depth-First Search
	 * TODO
	 * @param grid
	 * @return
	 * int
	 */
	public static int minPathSum2(int[][] grid){
		return dfs(0,0,grid);
	}
	
	public static int dfs(int currX, int currY, int[][] grid){
		if(currX == grid.length - 1 && currY == grid[0].length - 1){
			return grid[currX][currY];
		}
		if(currX < grid.length - 1 && currY < grid[0].length - 1){
			int downMin = grid[currX][currY] + dfs(currX+1,currY,grid);
			int rightMin = grid[currX][currY] + dfs(currX, currY+1, grid);
			return downMin > rightMin ? rightMin : downMin;
		}
		
		if(currX < grid.length - 1){
			return grid[currX][currY] + dfs(currX+1, currY, grid);
		}
		
		if(currY < grid[0].length - 1){
			return grid[currX][currY] + dfs(currX, currY+1, grid);
		}
		return 0;
	}
	
	
	
	
	
	
	
	

}
