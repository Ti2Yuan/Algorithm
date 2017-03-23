/**
 * 
 */
package tree;

import java.util.HashMap;

/**
 * Implement Trie(Prefix Tree)
 * 
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * Trie 树，
 * 又称字典树，单词查找树。它来源于retrieval(检索)中取中间四个字符构成(读音同try)。
 * 用于存储大量的字符串以便支持快速模式匹配。主要应用在信息检索领域。
 * 
 * Trie 有三种结构： 标准trie (standard trie)、压缩trie、后缀trie(suffix trie) 。
 * 
 * 总结：一个存储长度为n，来自大小为d的字母表中s个串的集合X的标准trie具有性质如下：
      (1) 树中每个内部结点至多有d个子结点。
      (2) 树有s个外部结点。
      (3) 树的高度等于X中最长串的长度。
      (4) 树中的结点数为O(n)。
 * 
 */
public class ImplementTrie {

	public static void main(String[] args){
		ImplementTrie iTrie = new ImplementTrie();
		iTrie.insert("bear");
		iTrie.insert("bell");
		iTrie.insert("bid");
		iTrie.insert("but");
		iTrie.insert("sell");
		iTrie.insert("stock");
		iTrie.insert("stop");
		
		System.out.println(iTrie.search("bid"));
		System.out.println(iTrie.startsWith("be"));
	}
	
	/**
	 * Your Trie object will be instantiated and called as such:
	 * Trie trie = new Trie();
	 * trie.insert("lintcode");
	 * trie.search("lint"); will return false
	 * trie.startsWith("lint"); will return true
	 * 
	 * 思路一：利用26大小的数组存储，每个数组结点又是一个26大小的数组，依次。。。。
	 * 思路二：hashmap的方式
	 */
	
	/**思路一的方式*/
	class TrieNode{
		private TrieNode[] children;
		public boolean hasWord;
		
		public TrieNode(){
			children = new TrieNode[26];
			hasWord = false;
		}
		
		public void insert(String word, int index){
			//如果遍历到字符串末尾,说明字典树（单词查找树）中添加成功这个单词了。
			if(index == word.length()){
				this.hasWord = true;
				return;
			}
			int pos = word.charAt(index) - 'a';
			if(children[pos] == null){
				children[pos] = new TrieNode();
			}
			children[pos].insert(word, index+1);
		}
		
		public TrieNode find(String word, int index){
			if(index == word.length()){
				return this;
			}
			int pos = word.charAt(index) - 'a';
			if(children[pos] == null){
				return null;
			}
			return children[pos].find(word, index+1);
		}
	}
	
	/**思路二HashMap的方式*/
	class TrieNode2{
		char c;
		HashMap<Character, TrieNode2> map = new HashMap<>();
		boolean hasWord;
		
		public TrieNode2(){
			
		}
		
		public TrieNode2(char c){
			this.c = c;
		}
		
		public void insert(String word, int index){
			if(index == word.length()){
				this.hasWord = true;
				return;
			}
			char c1 = word.charAt(index);
			if(map.get(c1) == null){
				TrieNode2 trieNode2 = new TrieNode2(c1);
				map.put(c1, trieNode2);
			}
			map.get(c1).insert(word, index+1);
		}
		
		public TrieNode2 find(String word, int index){
			if(index == word.length()){
				return this;
			}
			char c1 = word.charAt(index);
			if(map.get(c1) == null){
				return null;
			}
			return map.get(c1).find(word, index+1);
		}
	}
	
	private TrieNode root;
	private TrieNode2 root2;
	/** Initialize your data structure here. */
	public ImplementTrie() {
//		root = new TrieNode();
		root2 = new TrieNode2();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
//		root.insert(word, 0);
		root2.insert(word, 0);
		
		/*下面是对HashMap方式进行循环遍历的方式进行插入*/
		/*TrieNode2 curr = root2;
		HashMap<Character, TrieNode2> currMap = root2.map;
		char[] wordArray = word.toCharArray();
		for(int i = 0, len = wordArray.length; i < len; i++){
			char wc = wordArray[i];
			if(currMap.get(wc) == null){
				TrieNode2 node2 = new TrieNode2(wc);
				currMap.put(wc, node2);
				curr = node2;
			}else{
				curr = currMap.get(wc);
			}
			currMap = curr.map;
			if(i == len-1){
				curr.hasWord = true;
			}
		}*/
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
//		TrieNode node = root.find(word, 0);
//		return (node != null && node.hasWord);
		TrieNode2 node2 = root2.find(word, 0);
		return (node2 != null && node2.hasWord);
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
//		TrieNode node = root.find(prefix, 0);
//		return node != null;
		TrieNode2 node2 = root2.find(prefix, 0);
		return node2 != null;
	}

	/**
	 * Your ImplementTrie object will be instantiated and called as such: ImplementTrie
	 * obj = new ImplementTrie(); 
	 * obj.insert(word); boolean param_2 = obj.search(word); 
	 * boolean param_3 = obj.startsWith(prefix);
	 */

}
