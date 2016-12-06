package leetcode;
import java.util.Stack;

/**
 * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
 * ·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
 * ���һ��·�������˾����е�ĳһ�����ӣ����·�������ٽ���ø��ӡ� ���� a b c e s f c s a d e e
 * �����а���һ���ַ���"bcced"��·����
 * ���Ǿ����в�����"abcb"·������Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
 *
 *˼·����ջ�洢ÿ���ַ��������ҵ������ַ���ÿ��ȡ��ջ��Ԫ�ز��Ƴ������Ӵ� �Աȣ���Ԫ�ص��������Ҷ�û�����Ӵ���ȵģ����ٴ�ջ��ȡԪ�أ���Ӧ���Ӵ�indexҲҪ��1.
 */
public class PathInMatrix {

	public static void main(String[] args) {
		String s = "AAAAAAAAAAAA";
		char[] ss = s.toCharArray();
		String x = "AAAAAAAAAAAAA";
		char[] xx = x.toCharArray();
		char[] matrix = new char[] { 'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e' };
		int rows = 3;
		int cols = 4;
		char[] str = new char[] { 's', 'e', 'e'};
		System.out.println(hasPath(matrix, 3, 4, str));
	}

	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if (matrix == null || matrix.length != rows * cols || str == null || str.length <= 0)
			return false;
		int length = rows * cols;
		boolean[] flag = new boolean[length];
		Stack<Integer> resultStack = new Stack<Integer>();
		int addCount = 0;
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
					System.out.println("true of "+index2);
					// up
					coordinateCol = index2 % cols;
					coordinateRow = index2 / cols;
					if (coordinateRow - 1 >= 0) {
						int index = convertToIndex(coordinateRow - 1, coordinateCol, cols);
						if (!flag[index] && s == matrix[index]) {
//							flag[index] = true;
							resultStack.add(index);
							System.out.println("stack add "+index);
							addCount++;
						}
					}
					// down
					if (coordinateRow + 1 < rows) {
						int index = convertToIndex(coordinateRow + 1, coordinateCol, cols);
						if (!flag[index] && s == matrix[index]) {
//							flag[index] = true;
							resultStack.add(index);
							System.out.println("stack add "+index);
							addCount++;
						}
					}
					// left
					if (coordinateCol - 1 >= 0) {
						int index = convertToIndex(coordinateRow, coordinateCol - 1, cols);
						if (!flag[index] && s == matrix[index]) {
//							flag[index] = true;
							resultStack.add(index);
							System.out.println("stack add "+index);
							addCount++;
						}
					}
					// right
					if (coordinateCol + 1 < cols) {
						int index = convertToIndex(coordinateRow, coordinateCol + 1, cols);
						if (!flag[index] && s == matrix[index]) {
//							flag[index] = true;
							resultStack.add(index);
							System.out.println("stack add "+index);
							addCount++;
						}
					}
					if(addCount == 0){
						flag[index2] = false;
						i--;
						System.out.println("false of "+index2);
					}else{
						i++;
						System.out.println("check str "+i);
						addCount = 0;
					}
				}
				if (i==str.length){
					return true;
				}
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
