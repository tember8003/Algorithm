import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.management.Query;

public class Main {
	static int N,M;
	static class Edge{
		int x;
		int y;
		public Edge(int x,int y) {
			this.x=x;
			this.y=y;
		}
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	static int result=-1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int[][] mapTemp = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0);
		
		System.out.println(result);
	}
	
	public static void dfs(int count) {
		if(count==3) {
			int[][] mapTemp = new int[N][M];
			Copy(mapTemp);
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==2) {
						findMaxByBFS(mapTemp, i, j);
					}
				}
			}
			result = Math.max(findMax(mapTemp), result);
			return;
		}
		else {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==0) {
						map[i][j]=1;
						dfs(count+1);
						map[i][j]=0;
					}
				}
			}
		}
	}
	
	public static void findMaxByBFS(int[][] mapTemp,int x,int y) {
		Queue<Edge> queue = new LinkedList<>();
		queue.offer(new Edge(x,y));
		
		while(!queue.isEmpty()) {
			Edge cur = queue.poll();
			for(int i=0; i<4; i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M || mapTemp[nx][ny]!=0) {
					continue;
				}
				
				mapTemp[nx][ny]=2;
				queue.offer(new Edge(nx,ny));
			}
		}
	}
	
	public static int findMax(int[][] map) {
		int count=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static void Copy(int[][] mapTemp) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				mapTemp[i][j]=map[i][j];
			}
		}
	}
}
