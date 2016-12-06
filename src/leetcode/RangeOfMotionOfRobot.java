package leetcode;
import java.util.Stack;

/**
 * ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
 * ���ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ� ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18��
 * ���ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
 * 
 * ����ջ���洢ÿ�������Ļ������ܹ�����ĸ���,Ȼ����ÿ�δ�ջ��ȡ��һ������.
 */
public class RangeOfMotionOfRobot {

	public static void main(String[] args) {

		int threshold = 5;
		int rows = 10;
		int cols = 10;
		System.out.println(movingCount(threshold,rows,cols));
	}

	public static int movingCount(int threshold, int rows, int cols) {
		if(rows <=0 || cols <= 0 || threshold <= 0){
			return -1;
		}
		int movingCount = 0;
		boolean[][] flag = new boolean[rows][cols];
		Stack<Integer> coordinateRow = new Stack<Integer>();
		Stack<Integer> coordinateCol = new Stack<Integer>();
		int currentRow = 0;
		int currentCol = 0;
		coordinateRow.add(currentRow);
		coordinateCol.add(currentCol);
		flag[currentRow][currentCol] = true;
		while (!coordinateRow.isEmpty() && !coordinateCol.isEmpty()) {
			currentRow = coordinateRow.peek();
			currentCol = coordinateCol.peek();
			coordinateRow.pop();
			coordinateCol.pop();
			// up
			if (currentRow - 1 > 0 && !flag[currentRow-1][currentCol] &&isAvailable(threshold, currentRow-1, currentCol)) {
				coordinateRow.add(currentRow-1);
				coordinateCol.add(currentCol);
				flag[currentRow-1][currentCol] = true;
				movingCount++;
			}
			//down
			if (currentRow + 1 < rows && !flag[currentRow+1][currentCol] &&isAvailable(threshold, currentRow+1, currentCol)) {
				coordinateRow.add(currentRow+1);
				coordinateCol.add(currentCol);
				flag[currentRow+1][currentCol] = true;
				movingCount++;
//				continue;
			}
			//left
			if (currentCol - 1 > 0 && !flag[currentRow][currentCol-1] &&isAvailable(threshold, currentRow, currentCol-1)) {
				coordinateRow.add(currentRow);
				coordinateCol.add(currentCol-1);
				flag[currentRow][currentCol-1] = true;
				movingCount++;
//				continue;
			}
			//right
			if (currentCol + 1 < cols && !flag[currentRow][currentCol+1] &&isAvailable(threshold, currentRow, currentCol+1)) {
				coordinateRow.add(currentRow);
				coordinateCol.add(currentCol+1);
				flag[currentRow][currentCol+1] = true;
				movingCount++;
//				continue;
			}
			
		}
		return movingCount+1;
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
	
	

}
