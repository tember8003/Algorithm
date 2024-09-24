import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge{
	int end;
	int weight;
	
	public Edge(int end, int weight) {
		this.end = end;
		this.weight=weight;
	}
}
public class Main {
	static int N;
	static ArrayList<Edge>[] list;
	static int result=0;
	static boolean[] visited;
	static int check;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i]= new ArrayList<Edge>();
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			while(true) {
				int end = Integer.parseInt(st.nextToken());
				if(end==-1) {
					break;
				}
				int weight = Integer.parseInt(st.nextToken());
				
				list[num].add(new Edge(end,weight));
			}
		}
		visited = new boolean[N+1];
		dfs(1,0);
		
		visited = new boolean[N+1];
		dfs(check,0);
		
		System.out.println(result);
	}
	public static void dfs(int edge, int weight) {
		if(weight > result) {
			result=weight;
			check=edge;
		}
		visited[edge] = true;
		
		for(int i=0; i<list[edge].size(); i++) {
			Edge e = list[edge].get(i);
			if(!visited[e.end]) {
				visited[e.end]=true;
				dfs(e.end,weight+e.weight);
			}
		}
	}
}
