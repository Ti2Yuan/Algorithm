/**
 * 
 */
package leetcode;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 * 
 * �����������ֵ�������Ŀ������������������⣬�Ƚ���Ҫ��ע������ڷ��źʹ���Խ������⡣���������Ŀ����Ϊ�����ó˳�����ȡ�����㣬����ֻ��ʹ��λ����ͼӼ�����
 * �Ƚ�ֱ�ӵķ������ñ�����һֱ��ȥ������ֱ��Ϊ0�����ַ����ĵ��������ǽ���Ĵ�С����������Ϊn���㷨���Ӷ���O(n)��
 * ��ô��û�а취�Ż��أ� ������Ǿ͵�ʹ��λ���㡣����֪���κ�һ���������Ա�ʾ����2����Ϊ�׵�һ�����������ϣ�
 * ��num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n���������������ʽ�Լ�����һλ�൱�ڳ���2���������ó�������ֱ�����ڱ�����֮ǰ�õ�һ�����Ļ���
 * Ȼ�����������ÿ�γ��Լ�ȥ���������������������Ӽ�2^k,Ȼ����������Ƶ�����ֱ����Ϊ0Ϊֹ��
 * ��Ϊ��������ĵ��������ǰ�2����ֱ���������������ʱ�临�Ӷ�ΪO(logn)���������£�
 *
 */
public class DivideTwoIntegers {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		int divisor = 2;
		int dividend = 6;
		int result = divide(dividend,divisor);
		System.out.println(result);
	}

	/**
	 * TODO 
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	private static int divide(int dividend, int divisor) {
		if(divisor == 0)
			return divisor > 0? Integer.MAX_VALUE:Integer.MIN_VALUE;
		if(dividend == 0)
			return 0;
		if(dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;
		
		boolean isNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
		
		long a = Math.abs((long)dividend);
		long b = Math.abs((long)divisor);
		int result = 0;
		while(a >= b){
			int shift = 0;
			while(a >= (b << shift)){
				shift++;
			}
			a -= (b<<(shift-1));
			result += 1<<(shift-1);
		}
		return isNegative?-result:result;
	}

}
