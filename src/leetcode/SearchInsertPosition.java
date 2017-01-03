/**
 * 
 */
package leetcode;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * You may assume no duplicates in the array.
 * Here are few examples. 
 * [1,3,5,6], 5 → 2 
 * [1,3,5,6], 2 → 1 
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 *
 *solution:
 *Binary search
 */
public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = new int[]{1,3,5,6};
		int target = 7;
		System.out.println("insert position is " + searchInsert(nums, target));
	}
	
    private static int searchInsert(int[] nums, int target) {
    	if(nums == null || nums.length == 0 ){
    		return 0;
    	}
    	if(target < nums[0]){
    		return 0;
    	}
    	int left = 0;
    	int right = nums.length - 1;
    	int mid = 0;
    	while(left <= right){
    		mid = (left + right) / 2;
    		if(nums[mid] == target){
    			return mid;
    		}else if (nums[mid] > target) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
    	}
    	return left; 
    }

}
