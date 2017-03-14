/**
 * 
 */
package stringandarray;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example, path = "/home/", => "/home" path = "/a/./b/../../c/", => "/c"
 * click to show corner cases.
 * 
 * Corner Cases: 
 * Did you consider the case where path = "/../"? 
 * In this case, you should return "/". 
 * 
 * Another corner case is the path might contain multiple slashes '/' together,
 * such as "/home//foo/". 
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class SimplifyPath {

	/**
	 * TODO
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		String path = "/home//foo/";
		System.out.println(simplifyPath(path));
	}

	public static String simplifyPath(String path){
		StringBuilder sb = new StringBuilder();
		if(path == null || path.length() <= 0)
			return sb.toString();
		Stack<String> stack = new Stack<>();
		String[] strs = path.split("/");
		
		for(int i = 0;i<strs.length;i++){
			if(strs[i].equals("..")){
				if(!stack.isEmpty()){
					stack.pop();
				}
			}else if(strs[i].equals("/")){  
				continue;
			}else if(strs[i].equals(".")){ //不做任何操作
				//stack.push(".");
			}else if(strs[i].length() > 0){
				stack.push(strs[i]);
			}
		}
		if(stack.isEmpty()){
			return "/";
		}
		LinkedList<String> list = new LinkedList<>();
		while(!stack.isEmpty()){
			list.addFirst(stack.pop());
		}
		while(!list.isEmpty()){
			sb.append("/"+list.poll());
		}
		return sb.toString();
	}
}
