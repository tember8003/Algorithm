import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	//전위 -> 후위 변경
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String formula = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<formula.length(); i++) {
			char now = formula.charAt(i);
			if(now == '+' || now == '*' || now == '/' || now=='-') {
				while(!stack.isEmpty() && priority(stack.peek()) >= priority(now)) {
					sb.append(stack.pop());
				}
				stack.add(now);
			}
			else if(now=='(') {
				stack.add(now);
			}
			else if(now==')') {
				while(!stack.isEmpty() && stack.peek()!='(') {
					sb.append(stack.pop());
				}
				stack.pop();
			}
			else {
				sb.append(now);
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.toString());
	}
	public static int priority(char operator) { //우선순위 따지기 (핵심)
		if(operator == '(' || operator==')') {
			return 0;
		}
		else if(operator=='+' || operator=='-') {
			return 1;
		}
		else if(operator=='*' || operator=='/'){
			return 2;
		}
		else {
			return -1;
		}
	}
}
