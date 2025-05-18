import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<ArrayList<Integer>> graph= new ArrayList<>();
	static int[] edgeCount;
	static int[] width;
	static int[] ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		edgeCount = new int[N+1];
		width = new int[N+1];
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			width[i]=num;
			
			int line = Integer.parseInt(st.nextToken());
			for(int j=0; j<line; j++) {
				int lineNum = Integer.parseInt(st.nextToken());
				
				graph.get(lineNum).add(i);
				edgeCount[i]++;
			}
		}
		
		System.out.println(TopologicalSort());
		bw.flush();
		bw.close();
		br.close();
	}
	public static int TopologicalSort() {
		Queue<Integer> queue = new LinkedList<>();
		
		ans = new int[N+1];
		for(int i=1; i<=N; i++) {
			ans[i]=width[i];
			if(edgeCount[i]==0) {
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int next: graph.get(cur)) {
				ans[next] = Math.max(ans[next], ans[cur]+width[next]);
				edgeCount[next]--;
				if(edgeCount[next]==0) {
					queue.offer(next);
				}
			}
		}
		
		int result = 0;
		for (int i = 1; i <= N; i++) {
			result = Math.max(result, ans[i]);
		}
		
		return result;
	}
}
