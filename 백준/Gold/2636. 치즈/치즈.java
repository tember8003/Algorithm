import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] map;
	static int cheese=0;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					cheese++;
				}
			}
		}
		
		int count=0;
		int time=0;
		while(cheese!=0) {
			visited = new boolean[n][m];
			count = cheese;
			time++;
			bfs();
		}
		
		System.out.println(time);
        System.out.println(count);
	}
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0,0});
		visited[0][0]=true;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				
				if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny]) {
					visited[nx][ny]=true;
					if(map[nx][ny]==0) {
						queue.offer(new int[] {nx,ny});
					}
					else {
						cheese--;
						map[nx][ny]=0;
					}
				}
			}
		}
	}
}
