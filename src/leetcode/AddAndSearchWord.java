/**
 * 
 */
package leetcode;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * trie:又称单词查找树，是一种树形结构，用于保存大量的字符串。优点是：利用字符串的公共前缀来节约存储空间。
 * 
 * Design a data structure that supports the following two operations:
 * <p>
 * void addWord(word) bool search(word) search(word) can search a literal word
 * or a regular expression string containing only letters a-z or '.'. A '.'
 * means it can represent any one letter.
 * <p>
 * For example:
 * <p>
 * addWord("bad") addWord("dad") addWord("mad") search("pad") -> false
 * search("bad") -> true search(".ad") -> true search("b..") -> true
 * <p>
 * Note: You may assume that all words are consist of lowercase letters a-z.
 * <p>
 * You should be familiar with how a Trie works. If not, please work on this
 * problem: Implement Trie (Prefix Tree) first.
 * <p>
 * Company Tags: Facebook Tags: Backtracking, Trie, Design Similar Problems: (M)
 * Implement Trie (Prefix Tree)
 */
public class AddAndSearchWord {

	private WordDictionary d;

	@Before
	public void setUp() {
		System.out.println("create a word dictionary instance");
		d = new WordDictionary();
	}

	@Test
	public void testEdgeCase() {
		System.out.println("test a word dictionary instance");
		d.add("a");
		d.add("bad");
		d.add("dad");
		d.add("mad");
		d.add("pad");
		Assert.assertTrue(d.search("."));
		d.add("ab");
		Assert.assertTrue(d.search("a"));
		Assert.assertTrue(d.search("a."));
		Assert.assertTrue(d.search("bad"));
		Assert.assertTrue(d.search(".ad"));
		Assert.assertTrue(d.search("b.."));
		Assert.assertTrue(d.search("abcdefg"));
	}

	@After
	public void tearDown() {
		System.out.println("destory the word dictionary instance");
		d = null;
	}

	/**
	 * Trie. Ctreate a trie in the word dictionary class.
	 */
	private class WordDictionary {

		TrieNode root = new TrieNode();

		// Adds a word into the data structure.
		public void add(String word) {
			if (word == null || word.length() == 0) {
				return;
			}
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (node.links[c - 'a'] == null) {
					node.links[c - 'a'] = new TrieNode();
				}
				node = node.links[c - 'a'];
			}
			node.isEnd = true;
		}

		// Returns if the word is in the data structure.
		// A word could contain the dot character '.' to represent any one
		// letter.
		public boolean search(String word) {
			if (word == null) {
				return false;
			}
			return searchPrefix(word, 0, root);
		}
		
		/**
		 * Backtracking.回溯
		 * Statement: Given a word, a position, and a trie node, find whether the word is in the trie.
		 * Recurrent relation:
		 * The word is in the trie if current character at pos match and other character from pos+1 are in too.
		 * Base case:
		 * When subset is empty, return whether the node is end.
		 * Current char can be '.' or a letter.
		 * If it's not dot:
		 * | Get the next node.
		 * | Return next is not null && search(word, pos + 1, next).
		 * <p>
		 * If it's a dot, how to deal with it? '.' can match any character.
		 * | As long as current node has non-null link, search the rest of the prefix in trie.
		 * | If one of them returns true, return true.
		 * Return false.
		 */
		private boolean searchPrefix(String word, int pos, TrieNode node){
			if(pos == word.length()){
				return node.isEnd;
			}
			if(word.charAt(pos) == '.'){
				for(int i=0;i<node.links.length;i++){
					if(node.links[i] != null && searchPrefix(word, pos+1, node.links[i])){
						return true;
					}
				}
			}else {
				TrieNode next = node.links[word.charAt(pos) - 'a'];
				return next != null && searchPrefix(word, pos+1, next);
			}
			return false;
		}

		class TrieNode {

			private final int R = 26;
			TrieNode[] links;
			boolean isEnd;

			public TrieNode() {
				links = new TrieNode[R];
			}
		}
	}
}
