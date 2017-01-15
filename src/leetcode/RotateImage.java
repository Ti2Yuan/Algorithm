/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise顺时针).
 * Follow up: Could you do this in-place?
 */
public class RotateImage {

	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		rotate(matrix);
		for (int[] is : matrix) {
			System.out.println(Arrays.toString(is));
		}
	}

    public static void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
        	return;
        }
        int length = matrix.length;
        for(int i = 0;i<length/2;i++){
        	for(int j = 0;j<(length+1)/2;j++){
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[length-1-j][i];
        		matrix[length-1-j][i] = matrix[length-1-i][length-1-j];
        		matrix[length-1-i][length-1-j] = matrix[j][length-1-i];
        		matrix[j][length-1-i] = temp;
        	}
        }
    }
}
