/**
 * 
 */
package leetcode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 使用随机算法产生一个数，要求把1-1000W之间这些数全部生成。（考察高效率，解决产生冲突的问题） 
 * 提高效率的地方有如下：
 * 1.初始化set集合的时候 Sets.newHashSetWithExpectedSize(value)，
 * 给初始化带个固定大小，减少了集合在扩容的时候，值重新复制的问题。这的效率稍有提高。 
 * 2.Random random = new Random();放在循环之外。
 *
 */
public class GenerateRandom {

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int limit = 10000000;
		Set<Integer> array = new HashSet<>(limit);
		Random random = new Random();
		long a = System.currentTimeMillis();
		while(array.size() < limit+1){
			int i = random.nextInt(limit+1);
			array.add(i);
		}
		System.out.println(System.currentTimeMillis() - a);
		System.out.println(array.size());
	}

}
