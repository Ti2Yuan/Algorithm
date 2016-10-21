package leetCode;
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		int n = 3;
		List<String> parenthesesList = new ArrayList<>();
		generateParenthesis(parenthesesList,"",n,n);
		for (String parentheses : parenthesesList) {
			System.out.println(parentheses);
		}
	}

	private static void generateParenthesis(List<String> parenthesesList, String str, int left, int right) {

		if(left ==0 && right ==0){
			parenthesesList.add(str);
			return;
		}
		if(left > 0){
			generateParenthesis(parenthesesList,str+"(",left - 1,right);
		}
		if(right > 0 && left < right){
			generateParenthesis(parenthesesList,str+")",left,right -1);
		}
	}

}
