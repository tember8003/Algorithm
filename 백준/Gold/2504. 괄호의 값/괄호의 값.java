import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line=br.readLine();
		Stack<Character> stack = new Stack<>();
		int temp=1;
		int answer=0;
		for(int i=0; i<line.length(); i++) {
			char c=line.charAt(i);
			if(c=='(') {
				stack.push(c);
				temp*=2;
			}
			else if(c=='[') {
				stack.push(c);
				temp*=3;
			}
			else {
				if(c==')') {
					if(stack.isEmpty() || stack.peek()!='(') {
						answer=0;
						break;
					}
					else if(line.charAt(i-1)=='(') {
						answer+=temp;
					}
					temp/=2;
					stack.pop();
				}
				else if(c==']') {
					if(stack.isEmpty() || stack.peek()!='[') {
						answer=0;
						break;
					}
					else if(line.charAt(i-1)=='[') {
						answer+=temp;
					}
					temp/=3;
					stack.pop();
				}
			}
		}
		if(!stack.isEmpty()) {
			answer=0;
		}
		System.out.println(answer);
	}
}