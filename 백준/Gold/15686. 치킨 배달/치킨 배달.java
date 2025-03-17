import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int MAX = 987654321;
	static int N,M;
	static int[][] map;
	static boolean[] visited;
	static class Edge{
		int x;
		int y;
		Edge(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	static ArrayList<Edge> home;
	static ArrayList<Edge> chicken;
	static int result= MAX;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					home.add(new Edge(i, j));
				}
				else if(map[i][j]==2) {
					chicken.add(new Edge(i,j));
				}
			}
		}
		
		visited=new boolean[chicken.size()];
		
		DFS(0,0);
		System.out.println(result);
	}
	
	public static void DFS(int start, int cnt) {
		if(cnt==M) {
			int res = 0;
			
			for(int i=0; i<home.size(); i++) {
				int temp = Integer.MAX_VALUE;
				
				for(int j=0; j<chicken.size(); j++) {
					if(visited[j]) {
						int distance = Math.abs(home.get(i).x - chicken.get(j).x)+ Math.abs(home.get(i).y - chicken.get(j).y);
						
						temp = Math.min(distance, temp);
					}
				}
				res += temp;
			}
			result = Math.min(res, result);
		}
		for(int i= start; i<chicken.size(); i++) {
			visited[i] = true;
			DFS(i+1,cnt+1);
			visited[i]=false;
		}
	}
}
	