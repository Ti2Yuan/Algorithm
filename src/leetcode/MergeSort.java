package leetcode;
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 5, 9, 10, 1, 7, -1, -9, -40, 80, 100 };
		merge_sort(arr);
	}

	private static void merge_sort(int[] arr) {
		int len = arr.length;
		int[] result = new int[len];
		merge_sort_recursive(arr, result, 0, len - 1);
		for(int i = 0;i<arr.length;i++){
			System.out.print(arr[i]+"  ");
		}
		System.out.println();
		for(int i = 0;i<arr.length;i++){
			System.out.print(result[i]+"  ");
		}
	}

	private static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
		if (start >= end) {
			return;
		}
		int left = start, right = end;
		int mid = (start + end) / 2;
		merge_sort_recursive(arr, result, left, mid);
		merge_sort_recursive(arr, result, mid + 1, end);
		merge(arr, start, mid, end, result);
	}

	private static void merge(int[] arr, int start, int mid, int end, int[] result) {
		int left1 = start;
		int left2 = mid + 1;
		int index = start;
		
		//merge two sorted subArrays in arr to a result array
		while(left1 <= mid && left2 <= end){
			if(arr[left1] < arr[left2]){
				result[index++] = arr[left1++];
			}else{
				result[index++] = arr[left2++];
			}
		}
		while(left1 <= mid){
			result[index++] = arr[left1++];
		}
		while(left2 <= end){
			result[index++] = arr[left2++];
		}
		
		//copy temp back to arr
		for(index = start;index <= end;index++){
			arr[index] = result[index];
		}
	}

}
