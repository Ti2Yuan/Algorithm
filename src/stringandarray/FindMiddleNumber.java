/**
 * 
 */
package stringandarray;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 找中间数（数组中小于此中间数的个数等于大于此中间数的个数）
 * 
 * 例如：
 * 6
 * 2 5 6 3 5 6 
 * 输出5
 * 4 
 * 2 3 6 7
 * 输出-1
 * 
 * 思路：
 * 先快速排序，然后寻找中间数的起始位置和结尾位置
 */
public class FindMiddleNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] array = null;
		int length = 0;
		while (in.hasNext()) {
			length = in.nextInt();
			array = new int[length];
			for (int i = 0; i < length; i++) {
				array[i] = in.nextInt();
				i++;
			}
		}

		if (array == null && array.length <= 0) {
			System.out.println(-1);
			return;
		}

		// int[] array = new int[] { 3,4,6,6,7 };
		// int length = 5;

		// 快速排序数组
		quickSort(array);
		System.out.println(Arrays.toString(array));

		int mid = (length - 1) / 2;
		int begin = mid;
		int end = mid;
		// 寻找中间数起始位置
		while (array[begin] == array[mid]) {
			begin--;
		}
		// 寻找中间数结尾位置
		while (array[end] == array[mid]) {
			end++;
		}

		if ((begin + 1) == (length - end)) {
			System.out.println(array[mid]);
			return;
		} else {
			System.out.println(-1);
			return;
		}
	}

	public static void quickSort(int[] array) {
		quick(array, 0, array.length - 1);
	}

	public static void quick(int[] array, int low, int high) {
		if (low < high) {
			int index = partition(array, low, high);
			quick(array, low, index - 1);
			quick(array, index + 1, high);
		}
	}

	public static int partition(int[] array, int low, int high) {
		int temp = array[low];
		while (low < high) {
			while (low < high && array[high] > temp) {
				high--;
			}
			if (low < high)
				array[low++] = array[high];
			while (low < high && array[low] < temp) {
				low++;
			}
			if (low < high)
				array[high--] = array[low];
		}
		array[low] = temp;
		return low;
	}


}
