package leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * Given a matrix of m * n elements(m rows, n columns), 
 * return all elements of the matrix in spiral order
 * 
 * For example
 * Given the following matrix
 * [ 
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9] 
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1,2,3,10},{4,5,6,11},{7,8,9,12},{13,14,15,16}};
		int[][] matrix2 = new int[][]{{1}};
		List<Integer> result = spiralOrder(matrix);
		System.out.println(result.toString());
	}
	
	public static List<Integer> spiralOrder(int[][] matrix){
		List<Integer> result = new ArrayList<Integer>();
		if(matrix == null || matrix.length == 0){
			return result;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		for(int i = 0;i<(m+1)/2;i++){
			//left
			int j = i;
			while(j<n-i){
				result.add(matrix[i][j]);
				j++;
			}
//			for(j = i;j<n-i;j++){
//				result.add(matrix[i][j]);
//			}
			j = n-i-1;
			int k = i+1;
			//down
			while(k<m-i){
				result.add(matrix[k][j]);
				k++;
			}
//			for(k = i+1;k<n-i;k++){
//				result.add(matrix[k][j]);
//			}
			k = m-i-1;
			//right
			while(j>i){
				if(k == i && (j-1)==i)
					break;
				result.add(matrix[k][j-1]);
				j--;
			}
//			for(;j>i;j--){
//				result.add(matrix[k][j-1]);
//			}
			j = i;
			//up
			while(k>i+1){
				result.add(matrix[k-1][j]);
				k--;
			}
//			for(;k>i+1;k--){
//				result.add(matrix[k-1][j]);
//			}
		}
		return result;
	}

}
