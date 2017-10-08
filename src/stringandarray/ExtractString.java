/**
 * 
 */
package stringandarray;

import java.util.Scanner;

/**
 * @author chenti
 *
 *例如：输入 2{efg}3{cd}ef
 *  输出：efgefgcdcdcdef
 */
public class ExtractString {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str = in.nextLine();
			char[] cs = str.toCharArray();
			process(cs);
		}
	}

	private static void process(char[] cs) {
		if(cs == null || cs.length <= 0){
			return;
		}
		StringBuilder sb = new StringBuilder();
		//helper(cs, 0, ,cs.length, sb);
		System.out.println(sb.toString());
	}

	private static void helper(char[] cs, int index, int length, StringBuilder sb) {
		if(index >= cs.length){
			return;
		}
		int k = index;
		while(cs[index] > '0' && cs[index] <= '9' && index < length){
			index++;
		}
		int num = 0;
		if(index > k && cs[index] == '{'){
			StringBuilder str = new StringBuilder();
			for(int j = k; j<index; j++){
				str.append(cs[j]);
			}
			k = index;
			num = Integer.parseInt(str.toString());
			while(cs[index] != '}' && index < length){
				if(cs[index] > '0' && cs[index] <= '9'){
					helper(cs, index, length, sb);
				}
				index++;
			}
			if(index < length){
				str = new StringBuilder();
				for(int j = k+1; j<index; j++){
					str.append(cs[j]);
				}
				for(int j = 0; j<num; j++){					
					sb.append(str.toString());
				}
			}
		}else if(index == k){
			
		}
		
	}

}
