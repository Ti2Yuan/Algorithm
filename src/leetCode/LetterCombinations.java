package leetCode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LetterCombinations {

	public static void main(String[] args) {
		LetterCombinations lCombinations = new LetterCombinations();
//		System.out.println(lCombinations.letterCombinations(lCombinations
//				.digitString()));
		lCombinations.intArray();
	}
	
	public int[] intArray() {
		int[] array = new int[100];
		int i=0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("please input int array:");
		int digit;
		while(scanner.hasNext()){
			digit = scanner.nextInt();
			array[i] = digit;
			i++;
		}
		System.out.println("please input a target:");
		int target = scanner.nextInt();
		scanner.close();
		System.out.println(array[1]);
		return array;
		
	}

	public String digitString() {
		Scanner scanner = new Scanner(System.in);
		String digits = scanner.next();
		scanner.close();
		return digits;

	}

	public List<String> letterCombinations(String digits) {
		List<String> strList = new ArrayList<String>();
		strList.add("");
		System.out.println(strList.size()+"");
		String[] letter = { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
				"tuv", "wxyz" };
		int length = digits.length();
		for (int i = 0; i < length; i++) {
			List<String> tempList = new ArrayList<String>();
			tempList.addAll(strList);
			System.out.println(tempList == strList);
			strList.clear();
			int digit = Integer.parseInt(digits.charAt(i) + "");
			System.out.println(digit);
			for (int j = 0, strSize = tempList.size(); j < strSize; j++) {
				int len = letter[digit].length();
				System.out.println("letter[digit].length" + len);
				for (int h = 0; h < len; h++) {
					String temp = tempList.get(j) + letter[digit].charAt(h);
					System.out.println(temp);
					strList.add(temp);
				}
			}
		}
		return strList;
	}

}
