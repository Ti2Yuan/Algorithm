/**
 * 
 */
package tree;

import java.util.HashMap;

/**
 *压缩Trie(Compressed Trie)
 *
 *压缩Trie类似于标准Trie，但它能保证trie中的每个内部结点至少有两个子节点(根结点除外)。
 *通过把单子结点链压缩进叶子节点来执行这个规则。
 *
 *给定一个标准前缀树，请写一段程序将其压缩。A：压缩前缀树其实就是将所有只有一个子节点的节点合并成一个，以减少没有意义的类似链表式的链接。
 */
public class CompressedTrie {

	public static void main(String[] args) {
	}

	/**先改造TrieNode，让它能存字符串而不只是字母*/
	class TrieNode{
		HashMap<Character, TrieNode> children = new HashMap<>();
		boolean isLeaf = false;
		String str;
		
		public TrieNode(){};
		
		public TrieNode(char c){
			this.str = String.valueOf(c);
		}
	}
	
	/*模拟一个已经构建成功的标准的字典树*/
	class Trie{

		public TrieNode getRoot() {
			return null;
		}
		
	}
	
	public void compressTrie(Trie t){
		compress(t.getRoot());
	}

	private void compress(TrieNode root) {
		if(root == null)
			return;
		if(root.children.size() == 1){
			TrieNode next = root.children.get(root.children.keySet().iterator().next());
			root.str = root.str + next.str;
			root.children = next.children;
			compress(next);
		}else{
			for(Character key: root.children.keySet()){
				compress(root.children.get(key));
			}
		}
	}
}
