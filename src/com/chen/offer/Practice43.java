
package com.chen.offer;

/**
 * ��n���������ڵ��ϣ��������ӳ���һ��ĵ���֮��Ϊs������n����ӡ��s�����п��ܵ�ֵ���ֵĸ��ʡ�
 *
 * 1. �ݹ�˼·�����ǿ����Ȱ�n�����ӷ�Ϊ���ѣ���һ��ֻ��һ������һ����n-1����
 * ��������һ���п��ܳ��ִ�1��6�ĵ�����������Ҫ�����1��6��ÿһ�ֵ�����ʣ�µ�n-1����������������͡�
 * ��������ʣ�µ�n-1�����ӻ��Ƿֳ����ѣ���һ��ֻ��һ�����ڶ�����n-2����
 * ���ǰ���һ���Ǹ��������ӵĵ�������һ�ֵ������ӵĵ�����ӣ��ٺ�ʣ�µ�n-2����������������͡�
 * ������������ǲ��ѷ��֣�����һ�ֵݹ��˼·���ݹ�����������������ֻʣ��һ�������ˡ�
 *
 * 2. ����f(m,n)��ʾͶ��m������ʱ������֮��n���ֵĴ���,Ͷ��m������ʱ�ĵ���֮��ֻ��Ͷ��m-1������ʱ�йء�
 * �ݹ鷽�̣�f(m,n)=f(m-1,n-1)+f(m-1,n-2)+f(m-1,n-3)+f(m-1,n-4)+f(m-1,n-5)+f(m-1,n-6)��
 * ��ʾ���ֵ�����Ϊn���ִ���������һ�ֵ�����Ϊn-1��n-2��n-3��n-4��n-5��n-6���ֵĴ���֮�͡�
 * ��ʼ��������һ�ֵ�f(1),f(2),f(3),f(4),f(5),f(6)������1.
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
	 *            ������������pProbabilities[]��qProbabilities[]���洢���ӵĵ���֮�͡�
	 *            ��һ��ѭ���У�һ������ĵ�n�������һ������ĵ�n-1��n-2��n-3��n-4��n-5�Լ�n-6��ĺ͡�
	 *            ����һ��ѭ���У����ǽ������������飨ͨ���ı����flagʵ�֣����ظ�������һ���̡�
	 */
	private static void printProbabilityByDP(int number) {
		if (number < 1)
			return;
		int maxValue = 6;
		int valueCount = maxValue * number + 1;
		int[][] pProbabilities = new int[2][valueCount];
		int flag = 0;
		// ��һ�����ӣ�����1,2,3,4,5,6��һ��
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
