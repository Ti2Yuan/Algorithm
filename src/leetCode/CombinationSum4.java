package leetCode;

import java.util.Arrays;

public class CombinationSum4 {

	public static void main(String[] args) {
		CombinationSum4 cSum4 = new CombinationSum4();
		int[] nums = new int[]{1,2,3};
		int target = 4;
		System.out.println(cSum4.combinationSum4(nums, target));
	}

	public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] res = new int[target + 1];
        for (int i = 1; i < res.length; i++) {
	    for (int num : nums) {
	        if (num > i)
		    break;
		else if (num == i)
		    res[i] += 1;
		else
		    res[i] += res[i-num];
	    }
	}
        return res[target];
    }
}
