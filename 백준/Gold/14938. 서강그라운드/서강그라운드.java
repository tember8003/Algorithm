import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge>{
		int num;
		int road;
		
		public Edge(int num,int road) {
			this.num = num;
			this.road = road;
		}
		
		@Override
		public int compareTo(Edge e) {
			return road - e.road;
		}
	}
	static ArrayList<ArrayList<Edge>> array = new ArrayList<>();
	static int N,M,R;
	static int[] item;
	static int[] dist;
	static boolean[] visited;
	static int result =0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		item = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<=N; i++) {
			array.add(new ArrayList<>());
		}
		
		
		for(int i=0; i<R; i++) {
			st= new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			int road = Integer.parseInt(st.nextToken());
			
			array.get(one).add(new Edge(two,road));
			array.get(two).add(new Edge(one, road));
		}
		
		dist = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			result = Math.max(result, dijkstra(i));
		}
		
		System.out.println(result);
	}
	public static int dijkstra(int start) {
		Arrays.fill(visited, false);
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start,0));
		dist[start]=0;
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(visited[cur.num]) {
				continue;
			}
			visited[cur.num]=true;
			
			for(Edge edge : array.get(cur.num)) {
				if(!visited[edge.num] && dist[edge.num] > dist[cur.num] + edge.road) {
					dist[edge.num] = dist[cur.num]+edge.road;
					pq.add(new Edge(edge.num,dist[edge.num]));
				}
			}
		}
		
		int res = 0;
		
		for(int i=1; i<=N; i++) {
			if(dist[i]<=M) {
				res += item[i];
			}
		}
		
		return res;
	}
}
