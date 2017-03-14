/**
 * 
 */
package stringandarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of strings, group anagrams谚语 together. For example, given:
 * ["eat", "tea", "tan", "ate", "nat", "bat"], Return:[ ["ate", "eat","tea"],
 * ["nat","tan"], ["bat"] ]
 *
 * 这是一道很经典的面试题了，在cc150里面也有，就是把一个数组按照易位构词分类。
 * 易位构词其实也很好理解，就是两个单词所包含的字符和数量都是一样的，只是顺序不同。
 * 
 * 这个题简单的版本是判断两个单词是不是anagram，一般来说有两种方法。
 * 
 * 第一种方法是用hashmap，key是字符，value是出现的次数，如果两个单词构成的hashmap相同，那么就是anagram。
 * 实现起来就是用一个构建hashmap，然后另一个在前面的hashmap中逐个去除，最后如果hashmap为空，即返回true。
 * 这个方法时间复杂度是O(m+n)，m，n分别是两个单词的长度。而空间复杂度是O(字符集的大小)。
 * 
 * 第二种方法是将两个单词排序，如果排序之后结果相同，就说明两个单词是anagram。
 * 这种方法的时间复杂度取决于排序算法，一般排序算法是O(nlogn)，如果字符集够小，也可以用线性的排序算法。
 * 
 * 还有一种方法，设置一个256大小的int数组，设置下标出现的数组值为1
 * 
 * 不过总体来说，如果是判断两个单词的，第一种方法要直接简单一些。
 * 
 * 接下来我们看看这道题，是在很多字符串里面按照anagram分类，如果用hashmap的方法，然后两两匹配，在分组会比较麻烦。
 * 而如果用排序的方法则有一个很大的优势，就是排序后的字符串可以作为一个key，也就是某一个class的id，
 * 如此只要对每一个字符串排序，然后建立一个hashmap，key是排序后的串，而value是所有属于这个key类的字符串，这样就可以比较简单的进行分类。
 * 假设我们有n个字符串，字符串最大长度是k，那么该算法的时间复杂度是O(nklogk)，其中O(klogk)是对每一个字符串排序（如果用线性算法也可以提高）。
 * 空间复杂度则是O(nk)，即hashmap的大小。
 */
public class GroupAnagrams {

	public static void main(String[] args) {
		String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> result = groupAnagrams(strs);
		for (List<String> list : result) {
			System.out.println(Arrays.toString(list.toArray()));
		}
	}

	//solution 1
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		if (strs == null || strs.length == 0)
			return result;
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] c = str.toCharArray();
			Arrays.sort(c);
			String key = new String(c);
			List<String> list = map.get(key);
            if(list == null){
                list = new ArrayList<String>();
            }
            list.add(str);
            map.put(key, list);
//			if(map.containsKey(string)){
//				map.get(string).add(str);
//			}else {
//				List<String> list = new ArrayList<>();
//				list.add(str);
//				map.put(string, list);
//			}
		}
		Set<String> keySet= map.keySet();
		for (String keyStr : keySet) {
			List<String> valueList = map.get(keyStr);
			Collections.sort(valueList);
			result.add(valueList);
		}
		return result;
	}
	
	//solution 2 faster
	public static List<List<String>> groupAnagrams2(String[] strs){
		List<List<String>> result = new ArrayList<List<String>>();
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }

            int hash = getHash(count);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<String>());
            }

            map.get(hash).add(str);
        }

        for (ArrayList<String> tmp : map.values()) {
            if (tmp.size() >= 1) {
                result.add(tmp);
            }
        }

        return result;
	}
	private static int getHash(int[] count) {
        int hash = 0;
        int a = 378551;
        int b = 63689;
        for (int num : count) {
            hash = hash * a + num;
            a = a * b;
        }
        return hash;
    }
}
