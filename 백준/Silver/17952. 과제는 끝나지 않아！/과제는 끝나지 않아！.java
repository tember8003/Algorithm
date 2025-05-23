import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<int[]> new_stack = new Stack<>();
		
		int result=0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if(num!=0) {
				int time = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				
				if(count==1) {
					result+=time;
				}
				else {
					new_stack.add(new int[] {time,count-1});
				}
			}
			else {
				if(new_stack.empty()) {
					continue;
				}
				
				new_stack.peek()[1]--;
				
				if(new_stack.peek()[1]<=0) {
					result+=new_stack.peek()[0];
					new_stack.pop();
				}
			}
		}
		
		System.out.println(result);
	}
}