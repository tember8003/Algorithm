import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edges implements Comparable<Edges>{
	int end;
	int weight;
	
	public Edges(int end,int weight) {
		this.end = end;
		this.weight = weight;
	}
	
	public int compareTo(Edges e) {
		return weight - e.weight;
	}
}

public class Main {
	//다익스트라 알고리즘
	static int V,E;
	static int start;
	static ArrayList<ArrayList<Edges>> list;
	static int[] dist;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		start = Integer.parseInt(br.readLine());
		
		list = new ArrayList<ArrayList<Edges>>();
		dist = new int[V+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i=0; i<=V; i++) {
			list.add(new ArrayList<Edges>());
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int startNum = Integer.parseInt(st.nextToken());
			int endNum = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.get(startNum).add(new Edges(endNum, weight));
		}
		
		dijkstra(start);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=V; i++) {
			if(dist[i]==Integer.MAX_VALUE) {
				sb.append("INF\n");
			}
			else {
				sb.append(dist[i]+"\n");
			}
		}
		System.out.println(sb.toString());

	}
	public static void dijkstra(int start) {
		PriorityQueue<Edges> pq = new PriorityQueue<Edges>();
		boolean[] check = new boolean[V+1];
		pq.add(new Edges(start, 0));
		dist[start]=0;
		
		while(!pq.isEmpty()) {
			Edges curEdges = pq.poll();
			int cur = curEdges.end;
			
			if(check[cur]) {
				continue;
			}
			check[cur]=true;
			
			for(Edges edge : list.get(cur)) {
				if(dist[edge.end] > dist[cur]+edge.weight) {
					dist[edge.end] = dist[cur]+edge.weight;
					pq.add(new Edges(edge.end, dist[edge.end]));
				}
			}
		}
	}
}
