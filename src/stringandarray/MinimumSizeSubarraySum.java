/**
 * 
 */
package stringandarray;

/**
 * 给定一个包含n个正整数的数组和一个正整数s，找出最小长度的连续子数组，它的和要大于等于s。如果找不到，就返回0
 * 例如：
 * [2,3,1,2,4,3] s=7
 * 结果：
 * [4,3]
 * 
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 * */
public class MinimumSizeSubarraySum {

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		int s=7;
		int[] nums = new int[]{2,3,1,2,4,3};
		System.out.println(minSubArrayLen(s, nums));
	}

	/**
	 * 从头开始遍历，维护一个开始指针和一个当前指针,当前和，当前长度，最小长度(初始值为Integer.MAX_VALUE)
	 * TODO
	 * @param s
	 * @param nums
	 * @return
	 * int
	 */
	public static int minSubArrayLen(int s, int[] nums){
		if(nums == null || nums.length <= 0 || s <= 0){
			return 0;
		}
		int len = nums.length;
		int beginIndex = 0;
		int currentIndex = 0;
		int currentSum = 0;
		int currentLen = 0;
		int minLen = Integer.MAX_VALUE;
		for(;currentIndex < len; currentIndex++){
			currentSum += nums[currentIndex];
			if(currentSum >= s){
				while(currentSum >= s){
					currentSum -= nums[beginIndex];
					beginIndex++;
				}
				currentLen = currentIndex - beginIndex + 2;
				minLen = Math.min(currentLen, minLen);
			}
		}
		return minLen == Integer.MAX_VALUE ? 0:minLen;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
