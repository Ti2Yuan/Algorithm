/**
 * 
 */
package tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Add and Search Word - Data structure design
 * 
 * Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
 */
public class AddandSearchWord {
	
	public class TrieNode{
		char c;
		HashMap<Character, TrieNode> children = new HashMap<>();
		boolean hasWord;
		
		public TrieNode(){};
		
		public TrieNode(char c){
			this.c = c;
		}
		
		public TrieNode find(String word, int index){
			if(index == word.length()){
				return this;
			}
			char c1 = word.charAt(index);
			TrieNode node = null;
			if(c1 == '.'){
				Set<Character> keySet = children.keySet();
				Iterator<Character> iter = keySet.iterator();
				TrieNode result = null;
				while(iter.hasNext()){
					node = children.get(iter.next());
					if((result = node.find(word, index+1)) != null && result.hasWord){
						return result;
					}
				}
				return result;
 			}else if(children.get(c1) == null){
				return null;
			}
			node = children.get(c1);
			return node.find(word, index+1);
		}
	}

	public static void main(String[] args) {
		AddandSearchWord iTrie = new AddandSearchWord();
		iTrie.addWord("WordDictionary");
		iTrie.addWord("addWord");
		iTrie.addWord("addWord");
		iTrie.addWord("search");
		iTrie.addWord("search");
		iTrie.addWord("search");
		iTrie.addWord("search");
		iTrie.addWord("search");
		iTrie.addWord("search");		
		
//		iTrie.search("pad");
//		iTrie.search("bad");
//		iTrie.search(".ad");
//		iTrie.search("b..");
		
		System.out.println(iTrie.search("a"));
		System.out.println(iTrie.search("a"));
		System.out.println(iTrie.search("."));
		System.out.println(iTrie.search("a"));
		System.out.println(iTrie.search(".ddWord"));
		System.out.println(iTrie.search("a"));
		System.out.println(iTrie.search(".a"));
		System.out.println(iTrie.search("s....."));
	}

	TrieNode root;
	
	/** Initialize your data structure here. */
    public AddandSearchWord() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word == null || word.length() == 0)
        	return;
        char[] wc = word.toCharArray();
        HashMap<Character, TrieNode> currChildren = root.children;
        TrieNode currNode;
        for(int i = 0, len = wc.length; i<len; i++){
        	char c1 = wc[i];
        	if(currChildren.get(c1) != null){
        		currNode = currChildren.get(c1);
        	}else{
        		TrieNode node = new TrieNode(c1);
        		currChildren.put(c1, node);
        		currNode = node;
        	}
        	currChildren = currNode.children;
        	if(i == len-1){
        		currNode.hasWord = true;
        	}
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	if(word == null || word.length() == 0)
    		return false;
    	TrieNode node = root.find(word, 0);
        return node != null && node.hasWord;
    }
    
    /**
     * Your AddandSearchWord object will be instantiated and called as such:
     * AddandSearchWord obj = new AddandSearchWord();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
}
