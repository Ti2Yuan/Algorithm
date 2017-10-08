package leetcode.dynamicprogramming;

/**
 * Climbing Stairs
 *
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Note: Given n will be a positive integer.
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 44;
        System.out.println(climbStairs2(n));
    }

    /**
     * 递归
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    private static int climbStairs2(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
