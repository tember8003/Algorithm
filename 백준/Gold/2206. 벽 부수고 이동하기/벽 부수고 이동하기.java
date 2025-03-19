import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Edge{
		int x;
		int y;
		int cnt;
		boolean broken;
		public Edge(int x,int y,int cnt, boolean broken) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.broken = broken;
		}
	}
	
	static int MAX = 987654321;
	static int N,M;
	static int[][] map;
	static boolean[][][] visited;
	static int result=MAX;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			String map_str = br.readLine();
			for(int j=1; j<=M; j++) {
				map[i][j] = map_str.charAt(j-1) - '0';
			}
		}
		
		BFS();
	}
	public static void BFS() {
		Queue<Edge> queue = new LinkedList<>();
		queue.offer(new Edge(1,1,1,false));
		visited = new boolean[2][N+1][M+1];
		
		while(!queue.isEmpty()) {
			Edge cur = queue.poll();
			
			if(cur.x==N && cur.y==M) {
				System.out.println(cur.cnt);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				
				if(nx < 1 || ny < 1 || nx > N || ny > M) {
					continue;
				}
				
				if(map[nx][ny]==0) {
					if(!cur.broken && !visited[0][nx][ny]) {
						queue.offer(new Edge(nx,ny,cur.cnt+1,false));
						visited[0][nx][ny]=true;
					}
					else if(cur.broken && !visited[1][nx][ny]) {
						queue.offer(new Edge(nx,ny,cur.cnt+1,true));
						visited[1][nx][ny]=true;
					}
				}
				else { //1일 때
					if(!cur.broken) {
						queue.add(new Edge(nx,ny,cur.cnt+1,true));
						visited[1][nx][ny]=true;
					}
				}
			}
		}
		System.out.println(-1);
	}
}
