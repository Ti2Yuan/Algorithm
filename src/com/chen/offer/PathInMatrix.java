/**
 * 
 */
package com.chen.offer;

import java.util.Stack;

/**
 * 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如[a b c e s f c s a d e e]
 * 是3*4矩阵，其包含字符串"bcced"的路径，但是矩阵中不包含“abcb”路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class PathInMatrix {

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
     
        if (matrix == null || matrix.length <= 0 || str == null || str.length <= 0)
            return false;
        int length = rows * cols;
        boolean[] flag = new boolean[length];
        Stack<Integer> resultStack = new Stack<Integer>();
        int addCount = 0;  //记录矩阵中一个字符周围是否有待校验的字符
        int coordinateRow = 0;
        int coordinateCol = 0;
        int i = 0;
        char c = str[i];
        for (int j = 0, len = matrix.length; j < len; j++) {
            if (c == matrix[j]) {
                coordinateCol = j % cols;
                coordinateRow = j / cols;
                flag[j] = true;
                resultStack.add(j);
                System.out.println("stack add "+j);
                i++;
                while (i<str.length && !resultStack.isEmpty()) {
                    char s = str[i];
                    int index2 = resultStack.peek();
                    resultStack.pop();
                    System.out.println("stack get and remove "+index2);
                    flag[index2] = true;
                    // up
                    coordinateCol = index2 % cols;
                    coordinateRow = index2 / cols;
                    if (coordinateRow - 1 >= 0) {
                        int index = convertToIndex(coordinateRow - 1, coordinateCol, cols);
                        if (!flag[index] && s == matrix[index]) {
//                          flag[index] = true;
                            resultStack.add(index);
                            System.out.println("stack add "+index);
                            addCount++;
                        }
                    }
                    // down
                    if (coordinateRow + 1 < rows) {
                        int index = convertToIndex(coordinateRow + 1, coordinateCol, cols);
                        if (!flag[index] && s == matrix[index]) {
//                          flag[index] = true;
                            resultStack.add(index);
                            System.out.println("stack add "+index);
                            addCount++;
                        }
                    }
                    // left
                    if (coordinateCol - 1 >= 0) {
                        int index = convertToIndex(coordinateRow, coordinateCol - 1, cols);
                        if (!flag[index] && s == matrix[index]) {
//                          flag[index] = true;
                            resultStack.add(index);
                            System.out.println("stack add "+index);
                            addCount++;
                        }
                    }
                    // right
                    if (coordinateCol + 1 < cols) {
                        int index = convertToIndex(coordinateRow, coordinateCol + 1, cols);
                        if (!flag[index] && s == matrix[index]) {
//                          flag[index] = true;
                            resultStack.add(index);
                            System.out.println("stack add "+index);
                            addCount++;
                        }
                    }
                    if(addCount == 0){
                        flag[index2] = false;
                        i--;
                    }else{
                        i++;
                        addCount = 0;
                    }
                }
                if (i==str.length)
                    return true;
                for(int k = 0,leng = flag.length;k<leng;k++){
                    flag[k] = false;
                }
                i=0;
            }      
        }      
        return false;      
    }
 
    public static int convertToIndex(int coordinateRow, int coordinateCol, int cols) {
        return coordinateRow * cols + coordinateCol;
 
    }
}
