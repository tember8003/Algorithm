import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		int[] F = new int[1000001];
		int[] num = new int[N];
		Stack<int[]> stack = new Stack<int[]>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] answer = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			num[i] = temp;
			F[temp]++;
		}
		
		for(int i=N-1; i >= 0; i--) {
			while(!stack.isEmpty()) {
				if(stack.peek()[1] > F[num[i]]) {
					answer[i] = stack.peek()[0];
					break;
				}
				else {
					stack.pop();
				}
			}
			if(stack.isEmpty()) {
				answer[i] = -1;
			}
			
			stack.push(new int[] {num[i],F[num[i]]});
		}
		for(int i=0; i<N; i++) {
			sb.append(answer[i]+" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}