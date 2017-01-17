/**
 * 
 */
package leetcode;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example: A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * 
 * 这道题是动态规划的题目，所用到的方法跟是在MaximumSubarray中介绍的套路，用“局部最优和全局最优解法”。
 * 我们维护一个到目前为止能跳到的最远距离，以及从当前一步出发能跳到的最远距离。
 * 局部最优local=A[i]+i，而全局最优则是global=Math.max(global,local)。
 * 递推式出来了，代码就比较容易实现了。因为只需要一次遍历时间复杂度是O(n)，而空间上是O(1)。
 */
public class JumpGame {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 5, 0, 0 };
		System.out.println(canJump(nums));
	}

	public static boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		int length = nums.length;
		int maxIndex = 0;
		for(int i = 0;i<=maxIndex && i<length;i++){
			maxIndex = Math.max(nums[i]+i, maxIndex);
			if(maxIndex >= length-1)
				return true;
		}
		return false;
	}
	
	public static boolean canJump2(int[] nums) {  
	    if(nums==null || nums.length==0)  
	        return false;  
	    int reach = 0;  
	    for(int i=0;i<=reach&&i<nums.length&&reach<nums.length;i++)  
	    {  
	        reach = Math.max(nums[i]+i,reach);  
	    }  
	    if(reach<nums.length-1)  
	        return false;  
	    return true;  
	}  
}
