/**
 * 
 */
package stringandarray;

import java.util.Scanner;

/**
 ***
 * 在一个N*N的数组中寻找所有横，竖，左上到右下，右上到左下，四种方向的直线连续D个数字的和里面最大的值 
 * 
 * 输入例子:
4 2
87 98 79 61
10 27 95 70
20 64 73 29
71 65 15 0

输出例子:
193
 */
public class MaxValueOfMatrix {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 0;
		int num = 0;
		int count = 0;
		int[][] matrix = null; //new int[][]{{87,98,79,61},{10,27,95,70},{20,64,73,29},{71,65,15,0}};
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){  // while处理多个case
			N = in.nextInt();
			num = in.nextInt();
			matrix = new int[N][N];
			for(int i = 0; i<N;i++){
				for(int j = 0;j<N;j++){
					matrix[i][j] = in.nextInt();
				}
			}
		}
		long currentSum = 0;
		long maxSum = 0;
		for(int i = 0;i<N;i++){
			for(int j = 0;j<N;j++){
				int x = i;
				int y = j;
				//右
				while(y <= N-1 && count < num){
					currentSum += matrix[x][y];
					y++;
					count++;
				}
				if(count == num){
					if(currentSum > maxSum){
						maxSum = currentSum;
					}
				}
				y = j;
				currentSum = 0;
				count = 0;
				//下
				while(x <= N-1 && count < num){
					currentSum += matrix[x][y];
					x++;
					count++;
				}
				if(count == num){
					if(currentSum > maxSum){
						maxSum = currentSum;
					}
				}
				x = i;
				currentSum = 0;
				count = 0;
				//左下
				while(y >= 0 && x <= N-1 && count < num){
					currentSum += matrix[x][y];
					x++;
					y--;
					count++;
				}
				if(count == num){
					if(currentSum > maxSum){
						maxSum = currentSum;
					}
				}
				x = i;
				y = j;
				currentSum = 0;
				count = 0;
				//右下
				while(y <= N-1 && x <= N-1 && count < num){
					currentSum += matrix[x][y];
					x++;
					y++;
					count++;
				}
				if(count == num){
					if(currentSum > maxSum){
						maxSum = currentSum;
					}
				}
				x = i;
				y = j;
				currentSum = 0;
				count = 0;
			}
		}
		System.out.println(maxSum);
	}

}
