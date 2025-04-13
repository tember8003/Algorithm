import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] edgeCount;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		edgeCount = new int[N+1];
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			
			graph.get(one).add(two);
			edgeCount[two]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=1; i<=N; i++) {
			if(edgeCount[i]==0) {
				pq.offer(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int pq_temp = pq.poll();
			
			sb.append(pq_temp+" ");
			
			List<Integer> list = graph.get(pq_temp);
			for(int i=0; i<list.size(); i++) {
				edgeCount[list.get(i)]--;
				if(edgeCount[list.get(i)]==0) {
					pq.offer(list.get(i));
				}
			}
		}
		System.out.println(sb.toString());
	}
}
