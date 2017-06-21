/**
 * 
 */
package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author chenti
 *
 *Given two words (start and end), and a dictionary, find the length of shortest transformaion
 *sequence from start to end, such that only one letter can be changed at a time
 *and each intermediate word must exist in the dictionary.
 *For example, given: 
 *start="hit"
 *end = "cog"
 *dict = ["hot", "dot", "dog", "lot","log"]
 *
 *One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" ->"cog", the program should return its length 5.
 */
public class WordLadder {

	public static class WordNode{
		String word;
		int numSteps;
		
		public WordNode(String word, int numSteps){
			this.word = word;
			this.numSteps = numSteps;
		}
	}
	
	public static void main(String[] args){
		String beginWord = "hit";
		String endWord = "cog";
		Set<String> dict = new HashSet<>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		System.out.println(ladderLength(beginWord, endWord, dict));
	}
	
	public static int ladderLength(String beginWord, String endWord, Set<String> wordDict){
		LinkedList<WordNode> queue = new LinkedList<>();
		queue.add(new WordNode(beginWord, 1));
		
		wordDict.add(endWord);
		while(!queue.isEmpty()){
			WordNode top = queue.remove();
			String word = top.word;
			
			
			if(word.equals(endWord)){
				return top.numSteps;
			}
			
			char[] arr = word.toCharArray();
			for(int i = 0; i<arr.length; i++){
				for(char c = 'a'; c<='z'; c++){
					char temp = arr[i];
					if(arr[i] != c){
						arr[i] = c;
					}
					String newWord = new String(arr);
					if(wordDict.contains(newWord)){
						queue.add(new WordNode(newWord, top.numSteps+1));
						wordDict.remove(newWord);
					}
					arr[i] = temp;
				}
			}
		}
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
