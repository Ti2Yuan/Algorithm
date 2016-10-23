
package com.chen.offer;

/**
 * 把n个骰子仍在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 * 1. 递归思路：我们可以先把n个骰子分为两堆：第一堆只有一个，另一个有n-1个。
 * 单独的那一个有可能出现从1到6的点数。我们需要计算从1到6的每一种点数和剩下的n-1个骰子来计算点数和。
 * 接下来把剩下的n-1个骰子还是分成两堆，第一堆只有一个，第二堆有n-2个。
 * 我们把上一轮那个单独骰子的点数和这一轮单独骰子的点数相加，再和剩下的n-2个骰子来计算点数和。
 * 分析到这里，我们不难发现，这是一种递归的思路。递归结束的条件就是最后只剩下一个骰子了。
 *
 * 2. 假设f(m,n)表示投第m个骰子时，点数之和n出现的次数,投第m个骰子时的点数之和只与投第m-1个骰子时有关。
 * 递归方程：f(m,n)=f(m-1,n-1)+f(m-1,n-2)+f(m-1,n-3)+f(m-1,n-4)+f(m-1,n-5)+f(m-1,n-6)，
 * 表示本轮点数和为n出现次数等于上一轮点数和为n-1，n-2，n-3，n-4，n-5，n-6出现的次数之和。
 * 初始条件：第一轮的f(1),f(2),f(3),f(4),f(5),f(6)均等于1.
 */
public class Practice43 {

	public static void main(String[] args) {
		int number = 6; // the number of dice

		/**
		 * 1.....recursive method,there are a lot of repeated computation,so it
		 * is not good print probability of sum added by points of upward side
		 * of each dice.
		 */
		System.out.println("recursive method result:");
		System.out.println();
		printProbabilityByRecursive(number);
		System.out.println();

		/**
		 * 2..dynamic programming
		 */
		System.out.println("dynamic programming method result:");
		System.out.println();
		printProbabilityByDP(number);
	}

	/**
	 * dynamic programming method
	 * 
	 * @param number
	 *            定义两个数组pProbabilities[]和qProbabilities[]来存储骰子的点数之和。
	 *            在一轮循环中，一个数组的第n项等于另一个数组的第n-1、n-2、n-3、n-4、n-5以及n-6项的和。
	 *            在下一轮循环中，我们交换这两个数组（通过改变变量flag实现）再重复计算这一过程。
	 */
	private static void printProbabilityByDP(int number) {
		if (number < 1)
			return;
		int maxValue = 6;
		int valueCount = maxValue * number + 1;
		int[][] pProbabilities = new int[2][valueCount];
		int flag = 0;
		// 第一个骰子，出现1,2,3,4,5,6各一次
		for (int i = 1; i <= maxValue; i++) {
			pProbabilities[flag][i] = 1;
		}
		for (int i = 2; i <= number; i++) {
			for (int j = 0; j < i; j++) {
				pProbabilities[1 - flag][j] = 0;
			}
			for (int j = i; j <= maxValue * i; j++) {
				pProbabilities[1 - flag][j] = 0;
				for (int k = 1; k < j && k <= maxValue; k++) {
					pProbabilities[1 - flag][j] += pProbabilities[flag][j - k];
				}
			}
			flag = 1-flag;
		}
		
		for (int i = number; i < valueCount; i++) {
			System.out.println("sum " + (i) + " count is " + pProbabilities[flag][i]);
		}

		double total = Math.pow(maxValue, number);
		for (int i = number; i < valueCount; i++) {
			System.out.println("sum " + (i) + " probability is " + pProbabilities[flag][i] / total);
		}
		
	}

	/**
	 * recursive method
	 */
	private static void printProbabilityByRecursive(int number) {
		if (number < 1)
			return;
		int maxValue = 6;
		int valueCount = maxValue * number - number + 1;
		int[] probabilities = new int[valueCount];
		int sum = 0;
		// calculate probability of each sum value
		probability(number, sum, probabilities, maxValue);

		for (int i = 0; i < valueCount; i++) {
			System.out.println("sum " + (i + number) + " count is " + probabilities[i]);
		}

		double total = Math.pow(maxValue, number);
		for (int i = 0; i < valueCount; i++) {
			System.out.println("sum " + (i + number) + " probability is " + probabilities[i] / total);
		}
	}

	private static void probability(int number, int sum, int[] probabilities, int maxValue) {
		for (int i = 1; i <= maxValue; i++) {
			probability(number, number - 1, i + sum, probabilities, maxValue);
		}
	}

	private static void probability(int number, int current, int sum, int[] probabilities, int maxValue) {
		if (current == 0) {
			probabilities[sum - number]++;
			return;
		}
		for (int i = 1; i <= maxValue; i++) {
			probability(number, current - 1, i + sum, probabilities, maxValue);
		}
	}

}
