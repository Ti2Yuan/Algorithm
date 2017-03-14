package stringandarray;

import java.util.Arrays;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * Your function should return length = 2, with the first two elements of nums being 2.
 */
public class RemoveElements {

	public static void main(String[] args) {

		int[] nums = new int[]{3,2,2,3};
		int value = 3;
		int newLength = removeElements2(nums,value);
		for(int i = 0;i<newLength;i++){
			System.out.print(nums[i]+"  ");
		}
		System.out.println();
	}

	/**
	 * 设置两个一头一尾指针，从头扫描，扫描到的话，就将尾部元素拷贝到当前位置
	 * TODO
	 * @param nums
	 * @param value
	 * @return
	 * int
	 */
	private static int removeElements(int[] nums, int value) {
		//return -1 if array nums is null or the length is 0
		if(nums == null || nums.length < 1)
			return -1;
		int start = 0;
		int last = nums.length - 1;
		while(start <= last){
			if(nums[start] == value){
				nums[start] = nums[last];
				last--;
			}else {
				start++;
			}
		}
		return last + 1;
	}

	/**
	 * 设置两个指针，i,j，当当前元素等于给定元素时，跳过，否则做替换，将给定元素给覆盖了
	 * TODO
	 * @param nums
	 * @param val
	 * @return
	 * int
	 */
	private static int removeElements2(int[] nums,int val){
		if(nums == null || nums.length < 1)
			return 0;
		int i = 0;
		int j = 0;
		for(int len = nums.length;i<len;i++){
			if(nums[i] == val)
				continue;
			nums[j] = nums[i];
			j++;
		}
		return j;
	}
}
