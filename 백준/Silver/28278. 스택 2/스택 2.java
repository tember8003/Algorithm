import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		StringBuilder sb=new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n=Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			String check=st.nextToken();
			if(check.equals("1")) {
				
				stack.push(Integer.parseInt(st.nextToken()));
			}
			else if(check.equals("2")) {
				if(!stack.isEmpty()) {
					sb.append(stack.lastElement()).append("\n");
					stack.pop();
				}
				else {
					sb.append(-1).append("\n");
				}
			}
			else if(check.equals("3")) {
				sb.append(stack.size()).append("\n");
			}
			else if(check.equals("4")) {
				if(stack.isEmpty()) {
					sb.append(1).append("\n");
				}
				else {
					sb.append(0).append("\n");
				}
			}
			else if(check.equals("5")) {
				if(!stack.isEmpty()) {
					sb.append(stack.lastElement()).append("\n");
				}
				else {
					sb.append(-1).append("\n");
				}
			}
		}
		br.close();
		System.out.println(sb);
		
	}
}