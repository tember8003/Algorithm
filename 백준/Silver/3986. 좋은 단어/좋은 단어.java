import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int count=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			WordCheck(s);
		}
		System.out.println(count);
		
	}
	public static void WordCheck(String s) {
		if(s.length()%2==1) {
			return;
		}
		Stack<Character> stack = new Stack<>();
		stack.add(s.charAt(0));
		for(int i=1; i<s.length(); i++) {
			if(stack.size()>0 && stack.peek()==s.charAt(i)) {
				stack.pop();
			}
			else {
				stack.add(s.charAt(i));
			}
		}
		if(stack.isEmpty()) {
			count++;
		}
	}
}
