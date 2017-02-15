/**
 * 
 */
package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given two binary strings, return their sum (also is binary string)
 * For example,
 * a = "11";
 * b = "1"
 * Return "100".
 * 
 */
public class AddBinary {

	@Test
	public void test(){
		Assert.assertEquals(addBinaryB("11", "11111"), "100010");
	}
	
	/**
	 * Math. String
	 * Initialize two pointers i and j at the end of a and b.
	 * Use one integer c for the carry.
	 * While i>= 0 or j >= 0 or c == 1:
	 * |Add char in a or 0 to carry c. Move i.
	 * |Add char in b or 0 to carry c. Move j.
	 * |c % 2 is the current digit.
	 * |Insert current digit to the front of result.
	 * |c / 2 is the next carry.
	 * Return result string.
	 * TODO
	 * @param a
	 * @param b
	 * @return
	 * String
	 */
	public String addBinary(String a, String b){
		if(a == null || a.length() == 0){
			return b;
		}
		if(b == null || b.length() == 0){
			return a;
		}
		StringBuilder res = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int c = 0;
		while(i >= 0 || j >= 0 || c == 1){
			c += (i >= 0 ? a.charAt(i--) - '0' : 0);
			c += (j >= 0 ? a.charAt(j--) - '0' : 0);
			res.insert(0,c % 2);
			c >>=1;
		}
		return res.toString();
	}
	
	/**
	 * Math, String.
	 * From end to start, do it digit-by-digit.
	 * Get current digits of a and b, add them up.
	 * Also use an integer to store carry from the previous addition.
	 * Store the sum to result and update carry for each round.
	 * Stop when longest string is reached.
	 * Remember to check carry before return, if carry is 1, it should still be in inserted to result.
	 * TODO
	 * @param a
	 * @param b
	 * @return
	 * String
	 */
	public String addBinaryB(String a, String b){
		int m = a.length();
		int n = b.length();
		int carry = 0;
		StringBuilder res = new StringBuilder();
		int i = 0;
		//The longer one of a and b
		while(i < m || i < n){
			int p = i < m ? a.charAt(m - 1 - i) - '0':0;
			int q = i < n ? b.charAt(n - 1 - i) - '0':0;
			int temp = p + q + carry;
			carry = temp / 2; //temp can be 0,1,2,3. When temp >= 2, carry=1; otherwise, carry is 0.
			res.insert(0, temp % 2); //when temp is odd, result is 1; otherwise, result is 0.
			i++;
		}
		return carry == 0?res.toString():"1"+res.toString();
	}
}
