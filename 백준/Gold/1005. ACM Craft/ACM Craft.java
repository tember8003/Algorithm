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
	static int[] time;
	static int[] edgeCount;
	static int[] ans;
	static int N,K,W;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			time = new int[N+1];
			edgeCount = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			graph.clear();
			for(int i=0; i<=N; i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int one = Integer.parseInt(st.nextToken());
				int two = Integer.parseInt(st.nextToken());
				
				graph.get(one).add(two);
				edgeCount[two]++;
			}
			
			W = Integer.parseInt(br.readLine());
			
			sb.append(TopologicalSort()+"\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	public static int TopologicalSort() {
		Queue<Integer> queue = new LinkedList<>();
		
		ans = new int[N+1];
		for(int i=1; i<=N; i++) {
			ans[i] = time[i];
			if(edgeCount[i]==0) {
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int next:graph.get(cur)) {
				ans[next] = Math.max(ans[next], ans[cur]+time[next]);
				edgeCount[next]--;
				if(edgeCount[next]==0) {
					queue.offer(next);
				}
			}
		}
		
		return ans[W];
	}
}
