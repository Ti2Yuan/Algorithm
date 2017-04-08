/**
 * 
 */
package stringandarray;

import java.util.Random;

/**
 * 扑克牌随机发牌
 * 
 * 对于52张牌，实现一个随机打乱扑克牌顺序的程序。52张牌使用int数组模拟
 * 
 * 该算法的难点是如何保证随机性！ 有个经典算法shuffle，就是遍历数组，在剩下的元素里再随机取一个元素，
 * 然后再在剩下的元素里再随机取一个元素。每次取完后，我们就不会让这个元素参与到下一次的选取。
 */
public class PokerDisorder {

	
	public void randomCards(){
		int[] data = new int[52];
		Random random = new Random();
		for(int i = 0; i<data.length; i++){
			data[i] = i;
		}
		for(int i = data.length - 1; i>0; i--){
			int temp = random.nextInt(i+1);  //产生[0,i]之间的随机数
			swap(data, i, temp);
		}
	}

	private void swap(int[] data, int i, int temp) {
		int curr = data[i];
		data[i] = data[temp];
		data[temp] = curr;
	}
}
