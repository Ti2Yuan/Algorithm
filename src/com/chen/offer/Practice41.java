package com.chen.offer;

/**
 * ��ָoffer��41��
 *
 * ��Ŀһ������һ����������������һ������s,�������в�����������ʹ�����ǵĺ�������s������ж�ԣ����һ�Լ���
 * 
 * ��Ŀ��������һ������s,��ӡ�����к�Ϊs�������������У����ٺ�����������, ��������15������1+2+3+4+5 = 4+5+6 = 7+8 =
 * 15�����Խ����ӡ��1~5,4~6,7~8
 * 
 * ��Ŀ�� ˼·��������Ŀһ��˼�룬��������small��big�ֱ��ʾ���е���Сֵ�����ֵ�� ���ȳ�ʼ��smallΪ1��bigΪ2.
 * �����small��big�����еĺʹ���s,���ǿ��Դ�������ȥ����С��ֵ��Ҳ��������small��ֵ���෴����С��s����������big��
 * ��Ϊ�����������Ҫ���������֣�����һֱ����small����1+s��/2Ϊֹ��
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
		// ��Ŀ��
		p.findContinousSequence(s);
	}

	/**
	 * ���Һ͵���s���������� ���ȳ�ʼ��smallΪ1��bigΪ2.
	 * �����small��big�����еĺʹ���s,���ǿ��Դ�������ȥ����С��ֵ��Ҳ��������small��ֵ�� 
	 * �෴����С��s����������big��
	 * ��Ϊ�����������Ҫ���������֣�����һֱ����small����1+s��/2Ϊֹ��
	 * 
	 * @param s //����
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
	 * ������data�в���������,֮�͵���s
	 * 
	 * @param data  ��������
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
