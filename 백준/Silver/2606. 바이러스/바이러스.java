import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int N,M;
	static int count =0;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1];
		
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int oneline = Integer.parseInt(st.nextToken());
			int twoline = Integer.parseInt(st.nextToken());
			
			graph.get(oneline).add(twoline);
			graph.get(twoline).add(oneline);
		}
		
		DFS(1);
		
		System.out.println(count);
	}
	public static void DFS(int x) {
		visited[x] = true;
		for(int i=0; i<graph.get(x).size(); i++) {
			int temp = graph.get(x).get(i);
			if(!visited[temp]) {
				DFS(temp);
				count++;
			}
		}
	}
}
