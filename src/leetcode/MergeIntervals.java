package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 * @author tichen
 * 
 * 这是一道关于interval数组结构的操作，在面试中也是一种比较常见的数据结构。
 * 假设这些interval是有序的（也就是说先按起始点排序，然后如果起始点相同就按结束点排序），那么要把它们合并就只需要按顺序读过来，
 * 如果当前一个和结果集中最后一个有重叠，那么就把结果集中最后一个元素设为当前元素的结束点
 * （不用改变起始点因为起始点有序，因为结果集中最后一个元素起始点已经比当前元素小了）。
 * 那么剩下的问题就是如何给interval排序，在java实现中就是要给interval自定义一个Comparator，
 * 规则是按起始点排序，然后如果起始点相同就按结束点排序。
 * 整个算法是先排序，然后再做一次线性遍历，时间复杂度是O(nlogn+n)=O(nlogn)，空间复杂度是O(1)，因为不需要额外空间，只有结果集的空间。
 *
 */
public class MergeIntervals {

	public static class Interval{
		int start;
		int end;
		public Interval() {
			start = 0;
			end = 0;
		}
		public Interval(int s, int e){
			start = s;
			end = e;
		}
	}
	
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 4));
		intervals.add(new Interval(3, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));
		List<Interval> list = merge(intervals);
		for (Interval interval : list) {
			System.out.println(interval.start + "  " +interval.end);
		}
	}

	public static List<Interval> merge(List<Interval> intervals){
		List<Interval> results = new ArrayList<>();
		if(intervals == null || intervals.size() <= 1){
			return intervals;
		}
		
		Collections.sort(intervals, new IntervalComparator());
		
		int length = intervals.size();
		Interval last = intervals.get(0);
		
		for(int i = 1; i<length; i++){
			Interval interval = intervals.get(i);
			if(interval.start <= last.end){
				last.end = Math.max(last.end, interval.end);
			}else {
				results.add(last);
				last = interval;
			}
		}
		results.add(last);
		return results;
	}
	
	private static class IntervalComparator implements Comparator<Interval>{

		@Override
		public int compare(Interval o1, Interval o2) {
			if(o1.start == o2.start)
				return o1.end - o2.end;
			return o1.start - o2.start;
		}
		
	}
}
