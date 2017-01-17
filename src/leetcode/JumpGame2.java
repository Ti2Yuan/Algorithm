/**
 * 
 */
package leetcode;

/**
 * Jump Game II
 * Given an array of non-negative integers, you are initially positioned
 * at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example: Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * 
 * Note: You can assume that you can always reach the last index.
 */
public class JumpGame2 {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 3, 1, 1,4 };
		System.out.println(jump(nums));
	}

	// 这道题是Jump Game的扩展，区别是这道题不仅要看能不能到达终点，而且要求到达终点的最少步数。
	// 其实思路和JumpGame还是类似的，只是原来的全局最优现在要分成step步最优和step-1步最优（假设当前步数是step）。
	// 当走到超过step-1步最远的位置时，说明step-1不能到达当前一步，我们就可以更新步数，将step+1。时间复杂度仍然是O(n)，空间复杂度也是O(1)。 
    public static int jump(int[] A) {
    	if(A==null || A.length==0)  
            return 0;  
        int lastReach = 0;  
        int reach = 0;  
        int step = 0;  
        for(int i=0;i<=reach&&i<A.length;i++)  
        {  
            if(i>lastReach)  
            {  
                step++;  
                lastReach = reach;  
            }  
            reach = Math.max(reach,A[i]+i);  
        }  
        if(reach<A.length-1)  
            return 0;  
        return step;
    }
}
