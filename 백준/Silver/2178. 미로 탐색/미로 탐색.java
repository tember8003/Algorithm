import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static int cnt=1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map= new int[N][M];
		visited=new boolean[N][M];
		String str;
		
		for(int i=0;i<N; i++) {
			str=br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		bfs();
		System.out.println(map[N-1][M-1]);
	}
	static void bfs() {
		var queue = new LinkedList<int[]>();
		queue.add(new int[] {0,0});
		int[] temp = new int[2];
		visited[0][0]=true;
		int y,x;
		int ny,nx;
		while(!queue.isEmpty()) {
			temp=queue.poll();
			y=temp[0];
			x=temp[1];
			for(int i=0; i<4; i++) {
				ny=y+dy[i];
				nx=x+dx[i];
				if(ny<0 || nx<0||ny>=N||nx>=M) {
					continue;
				}
				if(!visited[ny][nx] && map[ny][nx]==1) {
					visited[ny][nx]=true;
					map[ny][nx] += map[y][x];
					queue.add(new int[] {ny,nx});
				}
			}
		}
	}
	

}
