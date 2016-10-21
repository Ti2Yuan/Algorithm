package leetCode;

import java.util.Scanner;
import java.util.Vector;

public class GreatestSumOfSubArray {

	static boolean isValidData = false;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		GreatestSumOfSubArray greatestSumOfSubArray = new GreatestSumOfSubArray();
		Vector<Integer> pData = new Vector<>();
		Vector<Integer> pData2 = new Vector<>();
		
		pData.add(1);
		pData.add(-2);
		pData.add(3);
		pData.add(10);
		pData.add(-4);
		pData.add(7);
		pData.add(2);
		pData.add(-5);
		
//		while(scanner.hasNext() && scanner.next()!= "\n"){
//			pData.add(scanner.nextInt());
//		}
		System.out.println(isValidData ? greatestSumOfSubArray.findGreatestSumOfSubArray(pData):"input data is not valid");
	}
	
	public int findGreatestSumOfSubArray(Vector<Integer> pData) {
		if(pData == null || pData.size()<=0){
			isValidData = false;
			return 0;
		}
		isValidData = true;
		int sum=0;
		int sumMax=0;
		for(int i=0,len=pData.size();i<len;i++){
			sum += pData.get(i);
			if(sum <= pData.get(i)){
				sum = pData.get(i);
				sumMax = sum;
			}
			if(sum > sumMax){
				sumMax = sum;
			}
		}
		return sumMax;
	}
	
	public int findGreatestSumOfSubArrayBy() {
		return 0;
	}

}
