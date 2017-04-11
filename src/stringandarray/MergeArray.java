/**
 * 
 */
package stringandarray;

/**高效合并两个有序数组
 * 
 * 这里合并的两个子数组是在同个大数组里面的，如数组a[N]的前半段和后半段分别有序
 * 如何使a[N]变成一个整体有序数组？？
 *
 */
public class MergeArray {

	public static void main(String[] args) {
	}

	/**
	 * 用result数组作为中间变量，保存两个有序子数组的合并结果数组，再复制回原数组
	 * 
	 * 空间复杂度O(N),时间复杂度O(m+n),m,n为两个有序子数组的长度
	 * */
	public static void mergeArray(int[] a, int begin, int mid, int end, int[] result){
		int i = begin, j = mid+1;
		int m = mid, n = end;
		int k = 0;
		
		while(i <= m && j <= n){
			if(a[i] <= a[j]){
				result[k++] = a[i++];
			}else{
				result[k++] = a[j++];
			}
		}
		
		while(i <= m){
			result[k++] = a[i++];
		}
		
		while(j <= n){
			result[k++] = a[j++];
		}
		
		for(i = 0; i < k; i++){
			a[begin+i] = result[i];
		}
	}
	
	/**空间复杂度O(1)，时间复杂度最坏为O(N*N)
	 * 
	 * 不设中间变量数组，要求空间复杂度为O(1)
	 * 
	 * 可以通过交换+移位实现
	 * */
	public static void mergeArray2(int[] a, int n){
		if(n <= 0){
			return;
		}
		
		int i = 0, j = n/2;          //从中间开始分为两个子数组
		while(j < n && i < j){
			if(a[i] <= a[j]){
				i++;
			}else {
				swap(a, i, j);
				//每次发现一个a[i] > a[j]交换后，需要把i+1到j的子数组循环右移一位，（i+1） ~ （j）保持有序，这里可以优化
				for(int k = j - 1; k>i; k--){  
					swap(a, k, k+1);
				}
				i++;
				j++;
			}
			
		}
	}
	
	public static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	/**
	 * 优化第二种方法，交换+循环移位（不用中间变量，通过交换反转实现）。
	 * 
	 * 第二种方法中，每次移动的单位是一个数，效率低，可以采用块循环移动（单位是连续几个数）进行优化。
	 * 
	 * 空间复杂度O(1)，时间复杂度应该比O(m+n)要小
	 * */
	public static void mergeArray3(int[] a, int begin, int end){
		int i,j,k;
		i = begin;
		j = 1 + ((begin + end) >> 1); //两个子数组从中间位置开始分组
		while(i <= end  && j <= end && i < j){
			while( i <= end && a[i] < a[j])
				i++;
			k = j;
			while(j <= end && a[j] < a[i])   //找到连续的j索引项都小于a[i]，进行块循环移动
				j++;
			if(j > k){
				rotate(a, i, j - 1, j - k);       //数组a[i...j-1]循环右移j-k次，a[i..j-1]始终有序
			}
			
			i += (j - k + 1);    //第一个指针往后移动，因为循环右移后，数组a[i....i+j-k]是有序的
		}
	}
	
	//反转数组
	public static void reverse(int[] a, int begin, int end){
		for(;begin<end; begin++, end--){
			swap(a, begin, end);
		}
	}
	
	//通过反转来将数组两个子有序数组前后排序
	public static void rotate(int[] a, int begin, int end, int k){
		int len = end - begin + 1;
		k %= len;
		
		reverse(a, begin, end - k);
		reverse(a, end - k + 1, end);
		reverse(a, begin, end);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
