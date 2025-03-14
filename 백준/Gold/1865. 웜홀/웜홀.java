import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int MAX = 987654321;
	static int[] dist = new int[501];
	static class Edge{
		int end;
		int cost;
		
		public Edge(int end ,int cost) {
			this.end = end;
			this.cost = cost;
		}
	}
	static ArrayList<ArrayList<Edge>> graph;
	static int TC;
	static int N,M,W;
	static int S,E,T;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		
		for(int i=0; i<TC; i++) {
			graph = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			for(int k=0; k<=N; k++) {
				graph.add(new ArrayList<>());
			}
			
			for(int j=0; j<M; j++) {
				st = new StringTokenizer(br.readLine());
				S = Integer.parseInt(st.nextToken());
				E = Integer.parseInt(st.nextToken());
				T = Integer.parseInt(st.nextToken());
				graph.get(S).add(new Edge(E,T));
				graph.get(E).add(new Edge(S,T));
				
			}
			for(int j=0; j<W; j++) {
				st = new StringTokenizer(br.readLine());
				S = Integer.parseInt(st.nextToken());
				E = Integer.parseInt(st.nextToken());
				T = Integer.parseInt(st.nextToken());
				graph.get(S).add(new Edge(E, -T));
			}
			
			boolean isMinus=false;
			for(int x = 1; x<=N; x++) {
				if(BellmanFord(x)) {
					isMinus=true;
					sb.append("YES\n");
					break;
				}
			}
			if(!isMinus) {
				sb.append("NO\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static boolean BellmanFord(int start) {
		Arrays.fill(dist, MAX);
		dist[start]=0;
		boolean check= false;
		
		for(int i=1; i<N; i++) {
			check = false;
			for(int j=1; j<=N; j++) {
				for(Edge edge : graph.get(j)) {
					if(dist[j]!=MAX && dist[edge.end] > dist[j]+edge.cost) {
						dist[edge.end] = dist[j] + edge.cost;
						check=true;
					}
				}
			}
			if(!check) {
				break;
			}
			
		}
		
		if(check) {
			for(int i=1; i<=N; i++) {
				for(Edge edge:graph.get(i)) {
					if(dist[i] != MAX && dist[edge.end] > dist[i]+ edge.cost) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
