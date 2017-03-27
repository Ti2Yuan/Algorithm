/**
 * 
 */
package com.chen.offer;

import java.util.Stack;

/**
 * 机器人的运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 =
 * 19。请问该机器人能够达到多少个格子？
 */
public class RangeOfRobot {

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**循环方式，利用一个数组记录格子是否已被访问过，两个栈存储访问过的格子*/
	public int movingCount(int threshold, int rows, int cols) {
		int movingCount = 0;
		boolean[][] flag = new boolean[rows][cols];
		Stack<Integer> coordinateRow = new Stack<Integer>();
		Stack<Integer> coordinateCol = new Stack<Integer>();
		int currentRow = 0;
		int currentCol = 0;
		if (isAvailable(threshold, currentRow, currentCol)) {
			coordinateRow.add(currentRow);
			coordinateCol.add(currentCol);
			flag[currentRow][currentCol] = true;
			movingCount++;
		}
		while (!coordinateRow.isEmpty() && !coordinateCol.isEmpty()) {
			currentRow = coordinateRow.peek();
			currentCol = coordinateCol.peek();
			coordinateRow.pop();
			coordinateCol.pop();
			// up
			if (currentRow - 1 > 0 && !flag[currentRow - 1][currentCol]
					&& isAvailable(threshold, currentRow - 1, currentCol)) {
				coordinateRow.add(currentRow - 1);
				coordinateCol.add(currentCol);
				flag[currentRow - 1][currentCol] = true;
				movingCount++;
			}
			// down
			if (currentRow + 1 < rows && !flag[currentRow + 1][currentCol]
					&& isAvailable(threshold, currentRow + 1, currentCol)) {
				coordinateRow.add(currentRow + 1);
				coordinateCol.add(currentCol);
				flag[currentRow + 1][currentCol] = true;
				movingCount++;
				// continue;
			}
			// left
			if (currentCol - 1 > 0 && !flag[currentRow][currentCol - 1]
					&& isAvailable(threshold, currentRow, currentCol - 1)) {
				coordinateRow.add(currentRow);
				coordinateCol.add(currentCol - 1);
				flag[currentRow][currentCol - 1] = true;
				movingCount++;
				// continue;
			}
			// right
			if (currentCol + 1 < cols && !flag[currentRow][currentCol + 1]
					&& isAvailable(threshold, currentRow, currentCol + 1)) {
				coordinateRow.add(currentRow);
				coordinateCol.add(currentCol + 1);
				flag[currentRow][currentCol + 1] = true;
				movingCount++;
				// continue;
			}

		}
		return movingCount;
	}

	public static boolean isAvailable(int threshold, int currentRow, int currentCol) {
		int sum = 0;
		while (currentRow > 0) {
			sum += currentRow % 10;
			currentRow /= 10;
		}
		while (currentCol > 0) {
			sum += currentCol % 10;
			currentCol /= 10;
		}
		if (sum > threshold)
			return false;
		return true;
	}

	/**递归的方法*/
	public static int movingCountByRecursively(int threshold, int rows, int cols){
		boolean[][] flag = new boolean[rows][cols];
		return helper(0,0,rows,cols,flag,threshold);
	}

	public static int helper(int i, int j, int rows, int cols, boolean[][] flag, int threshold){
		if(i<0 || j<0 || i>= rows || j>=cols ||flag[i][j] || 
				!isAvailable(threshold, i, j)){
			return 0;
		}
		flag[i][j] = true;
		return helper(i-1, j, rows, cols, flag, threshold)
				+ helper(i+1, j, rows, cols, flag, threshold)
				+ helper(i, j-1, rows, cols, flag, threshold)
				+ helper(i, j+1, rows, cols, flag, threshold)
				+1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
