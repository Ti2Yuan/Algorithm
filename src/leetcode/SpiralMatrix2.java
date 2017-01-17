/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to
 * n^2 in spiral order.
 * 
 * For example, Given n = 3,
 * 
 * You should return the following matrix: 
 * [ 
 *   [ 1, 2, 3 ], 
 *   [ 8, 9, 4 ], 
 *   [ 7, 6, 5] 
 * ]
 */
public class SpiralMatrix2 {

	public static void main(String[] args) {
		int[][] matrix = generateMatrix(4);
		for (int[] is : matrix) {
			System.out.print(Arrays.toString(is));
			System.out.println();
		}
	}

    public static int[][] generateMatrix(int n) {
    	int[][] matrix = new int[n][n];
    	if(n <= 0){
    		return matrix;
    	}
    	int j = 0;
    	int rowIndex = 0;
    	int value = 1;
    	for(int i = 0;i<(n+1)/2;i++){
    		//right
    		j = i;
    		rowIndex = i;
    		while(j<n-i){
    			matrix[rowIndex][j] = value;
    			value++;
    			j++;
    		}
    		//down
    		j = n - i -1;
    		rowIndex = i+1;
    		while(rowIndex < n-i){
    			matrix[rowIndex][j] = value;
    			value++;
    			rowIndex++;
    		}
    		//left
    		j = n - i - 2;
    		rowIndex = n - i - 1;
    		while(j >= i){
    			matrix[rowIndex][j] = value;
    			value++;
    			j--;
    		}
    		//up
    		j = i;
    		rowIndex = n - i - 2;
    		while(rowIndex > i){
    			matrix[rowIndex][j] = value;
    			value++;
    			rowIndex--;
    		}
    	}
		return matrix;
    }
}
