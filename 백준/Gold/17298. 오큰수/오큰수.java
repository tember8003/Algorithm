import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st =new StringTokenizer(br.readLine());
		Stack<Integer> stacks = new Stack<Integer>();
		int[] numbers = new int[n];
		int[] answers= new int[n];
		for(int i=0; i<n; i++) {
			numbers[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=n-1; i>=0; i--) {
			while(!stacks.empty()) {
				if(stacks.peek()>numbers[i]) {
					answers[i]=stacks.peek();
					break;
				}
				else {
					stacks.pop();
				}
			}
			if(stacks.empty()) {
				answers[i]=-1;
			}
			stacks.push(numbers[i]);
		}
		for(int i=0; i<n; i++) {
			sb.append(answers[i]+" ");
		}
		System.out.println(sb.toString());
	}

}
