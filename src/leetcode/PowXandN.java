/**
 * 
 */
package leetcode;

/**
 * Implement pow(x, n).
 * 
 * 这道题是一道数值计算的题目，因为指数是可以使结果变大的运算，所以要注意越界的问题。
 * 如同在Sqrt(x)这道题中提到的，一般来说数值计算的题目可以用两种方法来解，
 * 一种是以2为基进行位处理的方法，
 * 另一种是用二分法。
 * 这道题这两种方法都可以解。
 * 第一种方法在Divide Two Integers使用过，就是把n看成是以2为基的位构成的，
 * 因此每一位是对应x的一个幂数，然后迭代直到n到最高位。
 * 比如说第一位对应x，第二位对应x*x,第三位对应x^4,...,第k位对应x^(2^(k-1)),可以看出后面一位对应的数等于前面一位对应数的平方，所以可以进行迭代。
 * 因为迭代次数等于n的位数，所以算法的时间复杂度是O(logn)。
 */
public class PowXandN {

	public static void main(String[] args) {
		double x = 2;
		int n = 5;
		System.out.println(myPow(x, n));
	}

	public static double myPow(double x, int n) {
		if (n == 0) {
			return 1.0;
		}
		if (n == 1) {
			return x;
		}
		
		boolean negative = false;
		boolean fraction = false;
		if (x < 0 && n % 2 == 1) {
			x = Math.abs(x);
			negative = true;
		}
		//注意Integer.MIN_VALUE的绝对值比Integer.MAX_VALUE>1,Math.abs(n)会出错
		if (n < 0) {
			if(n == Integer.MIN_VALUE){
				n++;
				x *=x;
			}
			n = Math.abs(n);
			fraction = true;
		}
		double result = helper(x, n);
		if (fraction) {
			result = 1 / result;
		}
		
		if (negative) {
			result = -result;
		}
		return result;
	}

	// x^n = x^(n/2)*x^(n/2)*x^(n%2);
	private static double helper(double x, int n) {
		if (n == 0) {
			return 1;
		}
		double res = helper(x, n / 2);
		if(res > Double.MAX_VALUE){
			return Double.MAX_VALUE;
		}
		res *= res;
		if (n % 2 == 1) {
			res *= x;
		}
		return res;
	}

}
