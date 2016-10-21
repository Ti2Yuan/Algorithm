package com.chen.offer;

/**
 * 剑指offer第41题
 *
 * 题目一：输入一个递增排序的数组和一个数字s,在数组中查找两个数，使得他们的和正好是s，如果有多对，输出一对即可
 * 
 * 题目二：输入一个整数s,打印出所有和为s的连续整数序列（至少含有两个数）, 例如输入15，由于1+2+3+4+5 = 4+5+6 = 7+8 =
 * 15，所以结果打印出1~5,4~6,7~8
 * 
 * 题目二 思路：利用题目一的思想，用两个数small和big分别表示序列的最小值和最大值。 首先初始化small为1，big为2.
 * 如果从small到big的序列的和大于s,我们可以从序列中去掉较小的值，也就是增大small的值。相反，和小于s，可以增大big。
 * 因为这个序列至少要有两个数字，我们一直增加small到（1+s）/2为止。
 * 
 * @author chenti
 *
 */
public class Practice41 {

	public static void main(String[] args) {
		Practice41 p = new Practice41();
		int[] data = new int[] { 1, 2, 3, 4, 7, 11, 15, 17 };
		int s = 20;
		p.findNumbersWithSum(data, s);
		// 题目二
		p.findContinousSequence(s);
	}

	/**
	 * 查找和等于s的连续序列 首先初始化small为1，big为2.
	 * 如果从small到big的序列的和大于s,我们可以从序列中去掉较小的值，也就是增大small的值。 
	 * 相反，和小于s，可以增大big。
	 * 因为这个序列至少要有两个数字，我们一直增加small到（1+s）/2为止。
	 * 
	 * @param s //正数
	 */
	private void findContinousSequence(int s) {
		if(s < 3 )
			return;
		int small = 1;
		int big = 2;
		int sum = 3;
		int i = 0;
		int j = 0;
		while(small <= (1+s)/2){
			if(sum<s){
				big++;
				sum += big;
			}else if(sum>s){
				sum -= small;
				small++;
			}else {
				for(j = small;j<=big;j++){
					System.out.print(j+"  ");
				}
				System.out.println();
				sum -= small;
				small++;
			}
		}
	}

	/**
	 * 在数组data中查找两个数,之和等于s
	 * 
	 * @param data  递增序列
	 * @param s
	 */
	private void findNumbersWithSum(int[] data, int s) {
		if(data == null || data.length < 0)
			return;
		int length = data.length;
		int smallIndex = 0;
		int bigIndex = length - 1;
		int sum = 0;
		while (bigIndex > smallIndex) {
			sum = data[smallIndex] + data[bigIndex];
			if (sum > s) {
				bigIndex--;
			} else if (sum < s) {
				smallIndex++;
			} else {
				System.out.print(data[smallIndex] + "  ");
				System.out.println(data[bigIndex]);
				smallIndex++;
				bigIndex--;
			}
		}
	}

}
