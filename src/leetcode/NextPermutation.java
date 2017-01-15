/**
 * 
 */
package leetcode;

/**
 * Next Permutation(下一个排列) Implement next permutation, which rearranges numbers
 * into the lexicographically(字典) next greater permutation of numbers. If such
 * arrangement is not possible, it must rearrange it as the lowest possible
 * order (ie, sorted in ascending order). The replacement must be in-place, do
 * not allocate extra memory. Here are some examples. Inputs are in the
 * left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2 
 * 3,2,1 → 1,2,3 
 * 1,1,5 → 1,5,1
 * 实现next permutation（下一个排列），重新排列数组中的数，使得到的新数组的字典序恰好大于原数组。
 * 如果不存在这样的排列，就将原数组从小到大排序。
 * 替换必须就地进行，不要分配额外的内存。
 */
public class NextPermutation {

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,3,2};
		for(int i = 0;i<nums.length;i++){
			System.out.print(nums[i]+" ");
		}
		System.out.println();
		nextPermutation(nums);
		for(int i = 0;i<nums.length;i++){
			System.out.print(nums[i]+" ");
		}
	}

	private static void nextPermutation(int[] nums) {
		if(nums == null || nums.length ==0){
			return;
		}
		int length = nums.length;
		int p = -1;
		int q = -1;
		for(int i = length - 1;i>0;i--){
			if(nums[i-1] < nums[i]){
				p = i - 1;
				break;
			}
		}
		//do not exist such arrangement
		if(p == -1){
			sortedInAscendingOrder(nums, 0, length-1);
			return;
		}
		for(int i = length - 1;i>p;i--){
			if(nums[i] > nums[p]){
				q = i;
				break;
			}
		}
		swap(nums,p,q);
		sortedInAscendingOrder(nums,p+1,length-1);
	}

	/**
	 * TODO sorted in ascending order from index start to end of matrix nums 
	 * @param nums
	 * @param start
	 * @param end
	 * void
	 */
	private static void sortedInAscendingOrder(int[] nums, int start, int end) {
		// TODO Auto-generated method stub
		int len = end - start + 1;
		int mid = (start + end)/2;
		int temp = 0;
		while(start < mid && end > mid){
			swap(nums, start, end);
			start++;
			end--;
		}
		if(len%2 == 0){
			swap(nums, start, end);
		}
	}

	/**
	 * TODO swap nums[p] and nums[q]
	 * @param nums
	 * @param p
	 * @param q
	 * void
	 */
	private static void swap(int[] nums, int p, int q) {
		int temp = nums[p];
		nums[p] = nums[q];
		nums[q] = temp;
	}

}
