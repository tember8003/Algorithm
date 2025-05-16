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
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		edgeCount = new int[N+1];
		width = new int[N+1];
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			width[i]=w;
			
			while(true) {
				int num = Integer.parseInt(st.nextToken());
				if(num==-1) {
					break;
				}
				
				graph.get(num).add(i);
				edgeCount[i]++;
			}
		}
		TopologicalSort();
		for(int i=1; i<=N; i++) {
			sb.append(ans[i]+"\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	public static void TopologicalSort() {
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
	}
}
