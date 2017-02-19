/**
 * 
 */
package com.chen.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * 滑动窗口最大值 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 
 * 这实际上可以看成是TCP/IP中差错控制中滑动窗口的算法实现了。
 * 由于每次窗口大小是固定的，所以可以创建一个指针用于指向当前窗口的第一个值，而且位置该值是当前窗口的最大值的下标。
 * 这么做的好处在于每次窗口移动只需要从第一个位置取值就可以，时间复杂度是O(1)。
 * 那么具体需要在获取每个窗口的值得时候与队列中（需要创建一个队列用于保存每个窗口最大值的下标）的队尾指针的元素进行比较，
 * 如果比当前遍历到的元素小的话，需要把队尾元素移除，因为我们需要获得的是最大值。 这样一直遍历到最后一个元素，就把每个窗口的最大值获取到了。
 */
public class MaxInWindows {

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[] { 2, 3, 4, 2, 6, 2, 5, 1 };
		int size = 3;
		System.out.println(maxInWindows(num, size).toString());
	}

	/**
	 * 下面换一种思路。我们并不把滑动窗口的每个数值都存入队列中，而只把有可能成为滑动窗口最大值的数值存入到一个两端开口的队列。接着以输入数字{2,3,4,2,6,2,5,1}为例一步分析。
	 * 数组的第一个数字是2，把它存入队列中。第二个数字是3.由于它比前一个数字2大，因此2不可能成为滑动窗口中的最大值。2先从队列里删除，再把3存入到队列中。此时队列中只有一个数字3.针对第三个数字4的步骤类似，最终在队列中只剩下一个数字4.此时滑动窗口中已经有3个数字，而它的最大值4位于队列的头部。
	 * 接下来处理第四个数字2。2比队列中的数字4小。当4滑出窗口之后2还是有可能成为滑动窗口的最大值，因此把2存入队列的尾部。现在队列中有两个数字4和2，其中最大值4仍然位于队列的头部。
	 * 下一个数字是6.由于它比队列中已有的数字4和2都大，因此这时4和2已经不可能成为滑动窗口中的最大值。先把4和2从队列中删除，再把数字6存入队列。这个时候最大值6仍然位于队列的头部。
	 * 第六个数字是2.由于它比队列中已有的数字6小，所以2也存入队列的尾部。此时队列中有两个数字，其中最大值6位于队列的头部。
	 * 接下来的数字是5.在队列中已有的两个数字6和2里，2小于5，因此2不可能是一个滑动窗口的最大值，可以把它从队列的尾部删除。删除数字2之后，再把数字5存入队列。此时队列里剩下两个数字6和5，其中位于队列头部的是最大值6.
	 * 数组最后一个数字是1，把1存入队列的尾部。注意到位于队列头部的数字6是数组的第5个数字，此时的滑动窗口已经不包括这个数字了，因此应该把数字6从队列删除。那么怎么知道滑动窗口是否包括一个数字？应该在队列里存入数字在数组里的下标，而不是数值。当一个数字的下标与当前处理的数字的下标之差大于或者等于滑动窗口的大小时，这个数字已经从滑动窗口中滑出，可以从队列中删除了。
	 * TODO
	 * 
	 * @param num
	 * @param size
	 * @return ArrayList<Integer>
	 */
	public static List<Integer> maxInWindows(int[] data, int size) {
		List<Integer> windowMax = new LinkedList<>();

        // 条件检查
        if (data == null || size < 1 || data.length < 1) {
            return windowMax;
        }

        Deque<Integer> idx = new LinkedList<>();

        // 窗口还没有被填满时，找最大值的索引
        for (int i = 0; i < size && i < data.length; i++) {
            // 如果索引对应的值比之前存储的索引值对应的值大或者相等，就删除之前存储的值
            while (!idx.isEmpty() && data[i] >= data[idx.getLast()]) {
                idx.removeLast();
            }

            //  添加索引
            idx.addLast(i);
        }

        // 窗口已经被填满了
        for (int i = size; i < data.length; i++) {
            // 第一个窗口的最大值保存
            windowMax.add(data[idx.getFirst()]);

            // 如果索引对应的值比之前存储的索引值对应的值大或者相等，就删除之前存储的值
            while (!idx.isEmpty() && data[i] >= data[idx.getLast()]) {
                idx.removeLast();
            }

            // 删除已经滑出窗口的数据对应的下标
            if (!idx.isEmpty() && idx.getFirst() <= (i - size)) {
                idx.removeFirst();
            }

            // 可能的最大的下标索引入队
            idx.addLast(i);
        }

        // 最后一个窗口最大值入队
        windowMax.add(data[idx.getFirst()]);

        return windowMax;
		/*ArrayList<Integer> maxList = new ArrayList<Integer>();
		if (num == null || num.length == 0 || size <= 0 || num.length < size)
			return maxList;

		// 创建一个双端队列保存每个滑动窗口的最大值的下标
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		// 创建一个变量start用于记录当前滑动窗口的最大值的下标
		int start = 0;
		for (int i = 0; i < num.length; i++) {
			start = i + 1 - size;// 当start 大于0的时候表示第一个窗口已经不能再移动了
			if (queue.isEmpty()) {
				queue.add(i);
			} else if (start > queue.peekFirst()) { // 这个条件表示当前窗口start的值比上一个窗口的start值更大
				queue.pollFirst();
			}
			while (!queue.isEmpty() && num[queue.peekLast()] <= num[i]) {
				// 这种情况就表示，队列队尾位置对应的元素比当前元素小，就移除它，因为需要得到的是窗口的最大值
				queue.pollLast();
			}
			queue.add(i);
			if (start >= 0) {
				// 实际上当start=0的时候第一个滑动窗口，这是队列保存的是第一个滑动窗口最大值的小标，直接添加就行。
				maxList.add(num[queue.peekFirst()]);
			}
		}
		return maxList;*/
	}

	/**
	 * 1、简单的方法：
	 * 
	 * 遍历数组，从数组第w-1位开始，每次移动一位，并计算窗口w的最大值。
	 * 
	 * 时间复杂度：
	 * 
	 * 计算窗口的最大值需O(w)，移动n-w+1次，时间复杂度为O(nw)
	 */
	public static ArrayList<Integer> maxInWindows2(int[] num, int size) {
		if (num == null || num.length == 0 || size <= 0)
			return null;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < num.length - size + 1; i++) {
			result.add(getMax(num, i, size));
		}
		return result;
	}

	public static int getMax(int[] subNum, int start, int size) {
		int max = subNum[start];
		for (int i = start; i < size + start; i++) {
			if (subNum[i] > max)
				max = subNum[i];
		}
		return max;
	}
}
