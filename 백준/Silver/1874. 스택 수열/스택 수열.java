import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		int[] stack_num = new int[n];
		
		
		for(int i=0; i<n; i++) {
			stack_num[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 1;
		boolean check= true;
		for(int i=0; i<stack_num.length; i++) {
			for(; count<=stack_num[i]; count++) {
				stack.push(count);
				sb.append("+\n");
			}
			
			if(stack.peek()==stack_num[i]) {
				stack.pop();
				sb.append("-\n");
			}
			else {
				check=false;
				break;
			}
		}
		
		if(!check) {
			System.out.println("NO");
		}
		else {
			System.out.println(sb.toString());
        }
	}
}
