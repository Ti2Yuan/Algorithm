/**
 * 
 */
package com.chen.offer;

/**
 * 数值的整数次方
 */
public class DoublePower {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double base = 8.0;
		int exponent = 3;
		System.out.println(power(base, exponent));
		System.out.println(power2(base, exponent));
	}

	public static double power(double base, int exponent){
		double result = 0.0;
		if(equal(base,0.0) && exponent < 0){
			try {
				throw new Exception("0 的负次方无意义");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(exponent == 0){
			return 1.0;
		}
		
		if(exponent < 0){
			result = math(1/base, -exponent);
		}else {
			result = math(base, exponent);
		}
		return result;
	}
	
	public static boolean equal(double x, double y){
		return Math.abs(x - y) < 0.0000001 ? true:false;
	}
	
	public static double math(double base, int exponent){
		double result = 1.0;
		for(int i = 0;i<exponent;i++){
			result *= base;
		}
		return result;
	}
	
	//递归方式
	//a^n = a^(n/2) * a^(n/2)  n为偶数
	//a^n = a^(n/2) * a^(n/2)*a  n为奇数
	public static double power2(double base, int exponent){
		if(exponent == 0){
			return 1.0;
		}
		if(exponent == 1){
			return base;
		}
		double result = power2(base, exponent >> 1);
		result *= result;
		if((exponent & 0x1) == 1){
			result *= base;
		}
		return result;
	}
}
