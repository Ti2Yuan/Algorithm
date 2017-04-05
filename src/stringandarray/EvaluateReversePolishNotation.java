/**
 * 
 */
package stringandarray;

import java.util.Stack;

/**
 * Evaluate Reverse Polish Notation(评估反向波兰符号)
 * 
 *Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		String[] tokens = new String[]{"4","13","5","/","+"};
		System.out.println(evalRPN(tokens));
	}

	public static int evalRPN(String[] tokens){
		if(tokens == null || tokens.length == 0)
			return 0;
		Stack<String> operators = new Stack<>();
		Stack<Integer> operands = new Stack<>();
		int len = tokens.length;
		for(int i = 0; i<len+1; i++){
			if(operators.size() > 0){
				String oper = operators.pop();
				int num1 = operands.pop();
				int num2 = operands.pop();
				operands.push(process(oper,num1,num2));
			}
			if(i == len){
				break;
			}
			if(tokens[i].equals("+") || tokens[i].equals("-") ||
					tokens[i].equals("*") || tokens[i].equals("/")){
				operators.push(tokens[i]);
			}else{
				operands.push(Integer.parseInt(tokens[i]));
			}
		}
		return operands.pop();
	}

	private static int process(String oper, int num1, int num2) {
		if(oper.equals("+")){
			return num1+num2;
		}else if(oper.equals("-")){
			return num2-num1;
		}else if(oper.equals("*")){
			return num1*num2;
		}else if(oper.equals("/")){
			return num2/num1;
		}
		return 0;
	}
}
