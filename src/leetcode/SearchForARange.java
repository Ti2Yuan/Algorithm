/**
 * 
 */
package leetcode;

/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value. Your algorithm's runtime complexity must be in the order
 * of O(log n). If the target is not found in the array, return [-1, -1]. For
 * example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * 解题思路：
 * 这道题是二分查找Search Insert
 * Position的变体，思路并不复杂，就是先用二分查找找到其中一个target，然后再往左右找到target的边缘。找边缘的方法跟二分查找仍然是一样的，
 * 只是切半的条件变成相等，或者不等（往左边找则是小于，往右边找则是大于）。这样下来总共进行了三次二分查找，所以算法的时间复杂度仍是O(logn)，空间复杂度是O(1)。
 * 
 * 这里可以只用两次二分查找就足够了，确实如此。
 * 如果我们不寻找那个元素先，而是直接相等的时候也向一个方向继续夹逼，如果向右夹逼，最后就会停在右边界，而向左夹逼则会停在左边界，
 * 如此用停下来的两个边界就可以知道结果了，只需要两次二分查找。
 */
public class SearchForARange {

	public static void main(String[] args) {
		int[] nums = new int[] { 5, 7, 7, 8, 8, 10 };
		int target = 8;
		int[] result = searchRange(nums, target);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

	private static int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[]{-1,-1};
		}
		int start,end,mid;
		start = 0;
		end = nums.length - 1;
		int[] bound = new int[2];
		
		//search for left bound
		while(start + 1 < end){
			mid = (start + end)/2;
			if(nums[mid] == target){
				end = mid;
			}else if(nums[mid] > target){
				end = mid-1;
			}else{
				start = mid+1;
			}
		}
		if(nums[start] == target){
			bound[0] = start;
		}else if (nums[end] == target) {
			bound[0] = end;
		}else {
			bound[0] = bound[1] = -1;
			return bound;
		}
		
		//search for right bound
		start = 0;
		end = nums.length - 1;
		while(start + 1 < end){
			mid = (start + end)/2;
			if(nums[mid] == target){
				start = mid;
			}else if(nums[mid] > target){
				end = mid-1;
			}else{
				start = mid+1;
			}
		}
		if (nums[end] == target) {
            bound[1] = end;
        } else if (nums[start] == target) {
            bound[1] = start;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }
		return bound;
	}
}
