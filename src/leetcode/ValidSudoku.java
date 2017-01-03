/**
 * 
 */
package leetcode;

import java.util.Arrays;

import javax.xml.bind.ValidationEvent;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 * 
 * 
 * A partially filled sudoku which is valid.
 * 
 * Note: A valid Sudoku board (partially filled) is not necessarily solvable.
 * Only the filled cells need to be validated.
 * 
 * sulotion:
 * 检查一个数独9*9宫格是否是合格的:行列都不能够是重复的，且在0-9，子3*3宫格也要是合法的
 * 1. check rows
 * 2. check columns
 * 3. check sub matrix
 *
 */
public class ValidSudoku {

	public static void main(String[] args) {
		char[][] board = new char[][]{};
		System.out.println(isValidSudoku(board));
	}

    private static boolean isValidSudoku(char[][] board) {
    	boolean[] visited = new boolean[9];
    	
    	//check row
    	for(int i = 0;i<9;i++){
    		Arrays.fill(visited, false);
    		for(int j = 0;j<9;j++){
    			if(!validation(visited,board[i][j])){
    				return false;
    			}
    		}
    	}
    	
    	//check col
    	for(int j = 0;j<9;j++){
    		Arrays.fill(visited, false);
    		for(int i = 0;i<9;i++){
    			if(!validation(visited,board[i][j])){
    				return false;
    			}
    		}
    	}
    	
    	//check sub matrix
    	for(int i = 0;i<9;i+=3){
    		for(int j = 0;j<9;j+=3){
    			Arrays.fill(visited, false);
    			for(int k=0;k<9;k++){
    				if(!validation(visited, board[i+k/3][j+k%3])){
    					return false;
    				}
    			}
    		}
    	}
        return true;
    }

	/**
	 * TODO validate whether c has ever showed
	 * @param visited
	 * @param c
	 * @return
	 * boolean
	 */
	private static boolean validation(boolean[] visited, char c) {
		if(c == '.')
			return true;
		int value = c - '0';
		if(value < 1 || value > 9 || visited[value-1])
			return false;
		visited[value-1] = true;
		return true;
	}
}
