/**
 * 
 */
package leetcode;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

/**
 * Additive number is a string whose digits can form additive sequence.
 * 
 * A valid additive sequence should contain at least three numbers.
 * Except for the first two numbers, each subsequent number in the sequence must be the sum of 
 * the preceding two.
 * 
 * For example:
 * "112358" is an additive number because the digits can form an additive sequence: 1 1 2 3 5 8.
 * 1+1=2, 1+2=3, 2+3=5, 3+5=8
 * "199100199" is also an additive number, the additive sequence is: 1 99 100 199
 * 1+99=100, 99+100=199
 * 
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1,02,3 or 1,2,03 is invalid.
 * 
 * Given a string containing only digits '0'-'9', write a function to determine if it is an additive number.
 * 
 * Follow up:
 * How would you handle overflow for very large input integers? (String addition, BigInteger)
 */
public class AdditiveNumber {
	
	@Test
	public void test(){
		Assert.assertTrue(isAdditiveNumberB("199100199"));
	}
	
	/**
	 * Recursive
	 * Generate the first and second of the sequence, check if the rest of the string match the sum recursively.
	 * i is the length of first number, j is the length of second.
	 * TODO
	 * @param num
	 * @return
	 * boolean
	 */
	public boolean isAdditiveNumber(String num){
		int n = num.length();
		//Generate all possibilities
		//First number cannot be longer than half of the string
		for(int i = 1;i <= n/2;i++){
			//Cannot start with zero if length is larger than 2.
			if(num.charAt(0) == '0' && i>1){
				return false;
			}
			BigInteger num1 = new BigInteger(num.substring(0, i));
			//the remaining length should not be shorter than i or j
			for(int j=1;Math.max(i, j) <= n-i-j;j++){
				//can not start with zero if length is larger than 2, skip.
				if(num.charAt(i) == '0' && j>1){
					break;
				}
				BigInteger num2 = new BigInteger(num.substring(i,i+j));
				if(isAdditiveNumber(num1,num2,i+j,num)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * TODO Recursion
	 * Recurrence relation:
	 * isAdditiveNumber = can find the third number && rest of the string is also additive
	 * stop when reach the end.
	 * @param num1
	 * @param num2
	 * @param i
	 * @param num
	 * @return
	 * boolean
	 */
	private boolean isAdditiveNumber(BigInteger num1, BigInteger num2, int start, String num) {
		if(start == num.length()){
			return true;
		}
		num2 = num2.add(num1); // Get the sum
		num1 = num2.subtract(num1); //Get num2
		String sum = num2.toString();
		//Check if the sum exists in the string after start, and the rest is also additive
		return num.startsWith(sum, start) && isAdditiveNumber(num1, num2, start+sum.length(), num);
	}

	/**
	 * Iterative
	 * TODO
	 * @param num
	 * @return
	 * boolean
	 */
	public boolean isAdditiveNumberB(String num){
		int n = num.length();
		for(int i = 1;i<=n/2;i++){
			for(int j=1;Math.max(i, j) <= n-i-j;++j){
				if(isAdditiveNumberB(i,j,num)){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * TODO
	 * @param i length of first number
	 * @param j length of second number
	 * @param num the input string
	 * @return true if it's additive, false if not
	 * boolean 
	 */
	private boolean isAdditiveNumberB(int i, int j, String num) {
		if(num.charAt(0) == '0' && i>1){
			return false;
		}
		if(num.charAt(i) == '0' && j>1){
			return false;
		}
		String sum;
		BigInteger x1 = new BigInteger(num.substring(0,i));
		BigInteger x2 = new BigInteger(num.substring(i,i+j));
		// Move x1 and x2 one step forward
		for(int start = i+j; start != num.length(); start += sum.length()){
			//Sum, which is the number after x2
			x2 = x2.add(x1);
			x1 = x2.subtract(x1);
			sum = x2.toString();
			//Check if the next number exists
			if(!num.startsWith(sum,start)){
				return false;
			}
		}
		return true;
	}
	
}
