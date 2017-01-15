/**
 * 
 */
package leetcode;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 110. 
 * Both num1 and num2 contains only digits 0-9. 
 * Both num1 and num2 does not contain any leading zero. 
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * 
 * 首先我们把每一位相乘，得到一个没有进位的临时结果，如图中中间的一行红色数字就是临时结果，
 * 然后把临时结果从低位起依次进位。对于一个m位整数乘以n位整数的结果，最多只有m+n位。 
 */
public class MultiplyStrings {

	public static void main(String[] args) {

		String num1 = "9";
		String num2 = "99";
		System.out.println(multiply2(num1, num2));
	}

	//can not solve problem of big integer 
	public static String multiply(String num1, String num2) {
		String result = "0";
		if(num1.length() >= 110 || num2.length() >= 110)
			return result;
		if(num1.charAt(0) == '0' || num2.charAt(0) == '0')
			return result;
		long number1 = 0;
		long number2 = 0;
		int i,len;
		int j,len2;
		for(i=0,len = num1.length();i<len;i++){
			if(num1.charAt(i) < '0' || num1.charAt(i) > '9')
				break;
			number1 = (long) ((num1.charAt(i) - '0')*Math.pow(10, len - i - 1)) + number1;
		}
		if(i < len)
			return result;
		for(j=0,len2 = num2.length();j<len2;j++){
			if(num2.charAt(j) < '0' || num2.charAt(j) > '9')
				break;
			number2 = (long) ((num2.charAt(j) - '0')*Math.pow(10, len2 - j - 1)) + number2;
		}
		if(j < len2)
			return result;
		long multiplyVal = number1 * number2;
//		result = ""+multiplyVal;
		result = String.valueOf(multiplyVal);
		return result;
	}
	
	public static String multiply2(String num1, String num2){
		String result = "0";
		if(num1.length() >= 110 || num2.length() >= 110)
			return result;
		if(num1.charAt(0) == '0' || num2.charAt(0) == '0')
			return result;
		int m = num1.length();
		int n = num2.length();
		int k = m + n;
		int[] temp = new int[k];
		//首先我们把每一位相乘，得到一个没有进位的临时结果
		for(int i = 0; i< m; i++){
			for(int j = 0; j < n; j++){
				temp[i+j+1] += Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j)); 
			}
		}
		//把临时结果从低位起依次进位
		int val,carry = 0;
		for(int i = k-1; i>=0; i--){
			temp[i] += carry;
			val = temp[i]%10;
			carry = temp[i]/10;
			temp[i] = val;
		}
		int index = 0;
		while(temp[index] == 0){
			index++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=index;i<k;i++){
			sb.append(temp[i]+"");
		}
		return sb.toString();
	}
	
	//九章算法
	public static String multiply3(String num1, String num2){
		if (num1 == null || num2 == null) {
            return null;
        }
        
        int len1 = num1.length(), len2 = num2.length();
        int len3 = len1 + len2;
        int i, j, product, carry;

        int[] num3 = new int[len3];
        for (i = len1 - 1; i >= 0; i--) {
            carry = 0;
            for (j = len2 - 1; j >= 0; j--) {
                product = carry + num3[i + j + 1] +
                    Character.getNumericValue(num1.charAt(i)) *
                    Character.getNumericValue(num2.charAt(j));
                num3[i + j + 1] = product % 10;
                carry = product / 10;
            }
            num3[i + j + 1] = carry;
        }

        StringBuilder sb = new StringBuilder();
        i = 0;

        while (i < len3 - 1 && num3[i] == 0) {
            i++;
        }

        while (i < len3) {
            sb.append(num3[i++]);
        }

        return sb.toString();
	}
}
