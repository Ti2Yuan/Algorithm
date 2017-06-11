/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import leetcode.WordLadder.WordNode;

/**
 * @author chenti
 *
 *Given two words (start and end), and a dictionary, find the length of shortest transformaion
 *sequence(s) from start to end, such that 
 *1. only one letter can be changed at a time
 *2. each intermediate word must exist in the dictionary.
 *For example, given: 
 *start="hit"
 *end = "cog"
 *dict = ["hot", "dot", "dog", "lot","log"]
 *
 *return :
 *[
 *  ["hit","hot","dot","dog","cog"],
 *  ["hit","hot","lot","log","cog"]
 * ]
 *
 *solution:
 *This is an extension of WordLadder
 *This idea is the same. To track the actual ladder, we need to add a pointer that
 *points to the previous node in the WordNode class
 *In addition, the used word can not directly removed from the dictionary. 
 *The used word is only removed when steps changed.
 */
public class WordLadder2 {
	
	public static class WordNode{
		String word;
		int numSteps;
		WordNode pre;
		
		public WordNode(String word, int numSteps, WordNode pre){
			this.word = word;
			this.numSteps = numSteps;
			this.pre = pre;
		}
	}
	

	/**
	 * TODO
	 * @param args
	 * void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String beginWord = "hit";
		String endWord = "cog";
		Set<String> dict = new HashSet<>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		System.out.println(findLadders(beginWord, endWord, dict));
	}
	
	public static List<List<String>> findLadders(String start, String end, Set<String> dict){
		List<List<String>> result = new ArrayList<List<String>>();
		
		LinkedList<WordNode> queue = new LinkedList<>();
		queue.add(new WordNode(start, 1, null));
		
		dict.add(end);
		int minStep = 0;
		
		HashSet<String> visited = new HashSet<>();
		HashSet<String> unvisited = new HashSet<>();
		unvisited.addAll(dict);
		
		int preNumSteps = 0;
		while(!queue.isEmpty()){
			WordNode top = queue.remove();
			String word = top.word;
			int currNumSteps = top.numSteps;
			
			if(word.equals(end)){
				if(minStep == 0){
					minStep = currNumSteps;
				}
				
				if(top.numSteps == minStep && minStep != 0){
					ArrayList<String> t = new ArrayList<>();
					t.add(top.word);
					while(top.pre != null){
						t.add(0,top.pre.word);
						top = top.pre;
					}
					result.add(t);
					continue;
				}
			}
			
			if(preNumSteps < currNumSteps){
				unvisited.removeAll(visited);
			}
			
			preNumSteps = currNumSteps;
			
			char[] arr = word.toCharArray();
			for(int i = 0; i<arr.length; i++){
				for(char c = 'a'; c<='z'; c++){
					char temp = arr[i];
					if(arr[i] != c){
						arr[i] = c;
					}
					String newWord = new String(arr);
					if(unvisited.contains(newWord)){
						queue.add(new WordNode(newWord, top.numSteps+1, top));
						visited.add(newWord);
					}
					arr[i] = temp;
				}
			}
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
