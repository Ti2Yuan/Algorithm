package leetcode;

/**
 * Given n non-negative integers a1,a2,...,an, where each represents a point
 * at coordinate (i,ai). n vertical lines drawn such that the two endpoints of line 
 * i is at (i,ai) and (i,0). Find two lines, which together with x-axis
 * forms a container, such that the container contains the most water
 * 
 * Note: You may not slant(��б) the container
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height = new int[]{2,5,7,8,10,20,18,15};
		System.out.println(maxArea(height));
	}

	public static int maxArea(int[] height){
		if (height == null || height.length == 0) {
			return 0;
		}
		int begin = 0;
		int end = height.length - 1;
		int targetBegin = 0;
		int targetEnd = height.length - 1;
		int sum = 0;
		int maxArea = 0;
		while(begin < end){
			sum = (end - begin) * Math.min(height[begin], height[end]);
			if (sum > maxArea) {
				targetBegin = begin;
				targetEnd = end;
				maxArea = sum;
				System.out.println(targetBegin + " "+ targetEnd);
			}
//			maxArea = sum>maxArea?sum:maxArea;
			if(height[begin] > height[end]){
				end--;
			}else {
				begin++;
			}
		}
		return maxArea;
	}
}
