package com.chen.offer;

//1.每个数字异或自己都为0
//2.二进制和位运算的理解（n>>1 n右移一位，n & 1  n与1相与，看n的二进制第一位是否为1）

/**
 * 剑指offer第40题
 * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写出程序找出这两个只出现一次的数字
 * 要求时间复杂度为O(n),空间复杂度为O(1)
 * @author chenti
 *
 *
 *思路：我们想到异或运算的一个性质：任何一个数字异或它自己都等于0.
 *如果我们从头到尾一次异或数组中的每一个数字，那么最终的结果刚好是那个只出现一次的数字。
 *因为成对出现的数字都抵消了
 *那么在这个题目中，我们还是从头到尾异或每个数字，最后得到的结果就是两个只出现一次的数字异或的结果
 *由于这两个数字肯定不一样，所以异或的结果肯定不为0，也就是说这个结果数字的二进制表示中至少就有一位为1，
 *找到二进制表示右数第一个1，记为第n位。
 *我们根据这个1将原数组分成两个子数组，
 *第一个子数组中每个数字的第n位都是1，而另一个子数组都为0，同时那两个只出现一次的数分别位于两个子数组中。
 *在每个子数组中，除了那个只出现一次的数，其他都是成对出现的，异或结果就是那个只出现一次的数
 */
public class Practice40 {

	public static void main(String[] args) {
		Practice40 p = new Practice40();
		//the expected answer of the input data is 4 and 6
		int[] data = new int[]{2,4,3,6,3,2,5,5,10,10};
		int[] target = p.findNumsAppearOnce(data);
		for(int i:target){
			System.out.println(i);
		}
	}

	private int[] findNumsAppearOnce(int[] data) {
		int[] result = new int[2];
		int length = data.length;
		if(data == null || length < 2){
			return null;
		}
		int resultOfExclusiveOR = 0;
		for(int i = 0;i<length;i++){
			resultOfExclusiveOR ^= data[i];
			System.out.println(resultOfExclusiveOR);
		}
		int indexOfFirstBit1 = findFirstBit1(resultOfExclusiveOR);
		System.out.println("indexOfFirstBit1 is "+indexOfFirstBit1);
		for(int j = 0;j<length;j++){
			if(isBit1(data[j],indexOfFirstBit1)){
				result[0] ^= data[j];
			}else {
				result[1] ^= data[j];
			}
		}
		return result;
	}

	/**
	 * 判断这个数字二进制形式第n位是否是1
	 * @param n
	 * @return
	 */
	private boolean isBit1(int n,int index) {
		n = n >> index;
		return (n & 1)==0?false:true;
	}

	/**
	 * 找出异或的结果的二进制表示第一个1的位置
	 * @param resultOfExclusiveOR
	 * @return
	 */
	private int findFirstBit1(int resultOfExclusiveOR) {
		int indexOf1 = 0;
		while((resultOfExclusiveOR & 1) == 0 && (indexOf1 < 8 * 4))
		{
			resultOfExclusiveOR = resultOfExclusiveOR >> 1;
		    ++indexOf1;
		}
		return indexOf1;
	}

}
