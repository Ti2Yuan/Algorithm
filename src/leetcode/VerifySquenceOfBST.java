package leetcode;

/**
 * 验证序列是不是二叉树
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VerifySquenceOfBST {

	public static void main(String[] args) {
		VerifySquenceOfBST vBst = new VerifySquenceOfBST();
		int[] sequence = new int[] { 5, 7, 6, 11, 100, 9, 8 ,99};
		int length = sequence.length;
		boolean isSquenceOfBST = vBst.VerifySquence(sequence, length);
		System.out.println(isSquenceOfBST);
	}

	private boolean VerifySquence(int[] sequence, int length) {
		if (sequence == null || length <= 0)
			return false;
		int root = sequence[length - 1];
		int i = 0;
		while (sequence[i] < root) {
			i++;
		}
		int j = i;

		for (; j < length - 1; j++) {
			if (sequence[j] < root)
				return false;
		}
		// 判断左子树是不是二叉树
		boolean left = true;
		if (i > 0) {
			left = VerifySquence(sequence, i);
		}

		// 判断右子树是不是二叉树
		boolean right = true;
		if (i < length - 1) {
			right = VerifySquence(Arrays.copyOfRange(sequence, i, length - 1), length - i - 1);
		}
		return left & right;
	}

}
