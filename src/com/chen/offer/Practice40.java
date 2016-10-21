package com.chen.offer;

//1.ÿ����������Լ���Ϊ0
//2.�����ƺ�λ�������⣨n>>1 n����һλ��n & 1  n��1���룬��n�Ķ����Ƶ�һλ�Ƿ�Ϊ1��

/**
 * ��ָoffer��40��
 * ��Ŀ��һ�����������������������֮�⣬���������ֶ����������Ρ�
 * ��д�������ҳ�������ֻ����һ�ε�����
 * Ҫ��ʱ�临�Ӷ�ΪO(n),�ռ临�Ӷ�ΪO(1)
 * @author chenti
 *
 *
 *˼·�������뵽��������һ�����ʣ��κ�һ������������Լ�������0.
 *������Ǵ�ͷ��βһ����������е�ÿһ�����֣���ô���յĽ���պ����Ǹ�ֻ����һ�ε����֡�
 *��Ϊ�ɶԳ��ֵ����ֶ�������
 *��ô�������Ŀ�У����ǻ��Ǵ�ͷ��β���ÿ�����֣����õ��Ľ����������ֻ����һ�ε��������Ľ��
 *�������������ֿ϶���һ�����������Ľ���϶���Ϊ0��Ҳ����˵���������ֵĶ����Ʊ�ʾ�����پ���һλΪ1��
 *�ҵ������Ʊ�ʾ������һ��1����Ϊ��nλ��
 *���Ǹ������1��ԭ����ֳ����������飬
 *��һ����������ÿ�����ֵĵ�nλ����1������һ�������鶼Ϊ0��ͬʱ������ֻ����һ�ε����ֱ�λ�������������С�
 *��ÿ���������У������Ǹ�ֻ����һ�ε������������ǳɶԳ��ֵģ�����������Ǹ�ֻ����һ�ε���
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
	 * �ж�������ֶ�������ʽ��nλ�Ƿ���1
	 * @param n
	 * @return
	 */
	private boolean isBit1(int n,int index) {
		n = n >> index;
		return (n & 1)==0?false:true;
	}

	/**
	 * �ҳ����Ľ���Ķ����Ʊ�ʾ��һ��1��λ��
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
