package leetCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class StackIsPopOrder {

	public static void main(String[] args) {
		Vector<Integer> input = new Vector<>();
		Vector<Integer> output = new Vector<>();
//		int[] input = new int[];
//		int[] output = new int[] {};
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入入栈序列。。。。。。。。。");
		String temp = scanner.nextLine();
		String[] digitals = temp.split(" ");
		for (String digital : digitals) {
			input.add(Integer.parseInt(digital));
		}
		System.out.println("请输入出栈序列。。。。。。。。。");
		temp = scanner.nextLine();
		digitals = temp.split(" ");
		for (String digital : digitals) {
			output.add(Integer.parseInt(digital));
		}
		boolean isPopOrder = isPopOrder(input, output);
		System.out.println(isPopOrder);
	}

	private static boolean isPopOrder(Vector<Integer> input, Vector<Integer> output) {
		int inLen = input.size();
		int outLen = output.size();
		if (input == null || output == null || inLen == 0 || outLen == 0 || inLen != outLen)
			return false;
		Stack<Integer> stack = new Stack<>();
		int i = 0, j = 0;
		while (j < outLen) {
			// 如果栈为空或栈顶元素与要出栈的元素不相等时，将未入栈的数压入栈，直到找到相等的数
			if (stack.isEmpty() || stack.peek() != output.get(j)) {
				if (i >= inLen)
					return false;
				while (input.get(i) != output.get(j)) {
					stack.push(input.get(i++));
				}
				i++;
				j++;
			} else {
				stack.pop();
				j++;
			}
		}
		if (stack.isEmpty() && j == outLen && i == inLen)
			return true;
		return false;
	}

}
