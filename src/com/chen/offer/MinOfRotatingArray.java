/**
 * 
 */
package com.chen.offer;

/**
 * 旋转数组的最小数字
 * 
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 
 * 如果直接遍历数组，时间复杂度为O（n）,可以利用旋转数组的特性来解决此题；
 * 
 * 思路：
 * 
 * （1）如果发生旋转，前面的数至少去了一个放在数组的后面；
 * 
 * 1）旋转后，数组分为两个排序数组，而且前一个数组中的数均大于等于后一个数组中的数，因为要查找数组中的最小数，也就是第二个数组中的第一个数，可以采用二分查找的思想；
 * 
 * 2）设置两个指针p1,p2，p1指向数组的开始位置，也就是第一个数组的开始位置，p2指向数组的终止位置，也就是第二个数组的结束位置。Mid=p1+p2/2;
 * 
 * 如果中间位置mid的数大于p1指向的数，则mid在第一个数组中，让p1指向mid所指向的数，p1指向的依然是数组1的数；
 * 
 * 如果中间位置mid的数小于p2所指向的位置，则mid在第二个数组中，p2指向mid指向的数，p2指向的依然是数组2的数；
 * 
 * Mid不是指向数组1的数，就是指向数组2的数，指向数组1的数，就让p1移动到mid的位置，指向数组2就让p2数组移动到mid的位置；直到p2移动到数组1的结束的位置，p1移动到数组2的开始的位置，此时p2与p1挨着，而且p1所指向的数组2的起始位置中存放的就是最小数；
 * 
 * （2）如果中间位置的数既等于p1位置数，又等于p2位置的数，这时候，不能确定移哪个指针，就必须采用顺序查找的方法来寻找最小数；
 * 
 * 
 * 
 * 总结：此题就是利用两个指针，一个往后移，一个往前移，具体怎么移，通过mid的大小控制；直到两个指针的位置挨着，就可以找到最小数了!
 * 
 * 还需要考虑：
 * 
 * 如果数组取0个放在了数组的后面，也就是排序数组没有变，这时p1指向的数小于p2指向的数；直接是数组的首元素是最小的数；
 */
public class MinOfRotatingArray {

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{1,0,1,1,1,1,1};
		System.out.println(min(array));
	}

	public static int min(int[] array) {
		if (array == null || array.length <= 0)
			return -1;
		int start = 0;
		int end = array.length - 1;
		int min = array[start]; // 如果没有元素旋转到后面
		int mid = 0;
		while(array[start] >= array[end]){
			//发生了旋转
			if(end - start == 1){
				min = array[end];
				break;
			}
			mid = (start + end)/2;
			if(array[start] == array[end] && array[mid] == array[start]){
				//顺序查找
				min = minInOrder(array, start, end);  
				break;
			}
			
			if(array[start] < array[mid]){
				start = mid;
			}else if(array[end] > array[mid]){
				end = mid;
			}
		}
		return min;
	}
	
	public static int minInOrder(int[] array, int start, int end){
		int temp = array[start];
		for(int i = start+1;i<=end;i++){
			if(array[i] < temp)
				temp = array[i];
		}
		return temp;
	}
}
