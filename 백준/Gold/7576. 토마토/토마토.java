import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static int M,N;
	static int[][] map;
	static Queue<int[]> queue = new LinkedList<>();
	static int cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					queue.add(new int[] {i,j});
				}
			}
		}
		System.out.println(bfs());
	}
	public static int bfs() {
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y= temp[1];
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0 || ny<0||nx>=N || ny>=M) {
					continue;
				}
				if(map[nx][ny]==0) {
					map[nx][ny]=map[x][y]+1;
					queue.add(new int[] {nx,ny});
				}
			}
		}
		int max = Integer.MIN_VALUE;
		if(check()) {
			return -1; //만약 다 돌았는데 0이 있다면 토마토가 모두 익지 않았으므로 -1
		}
		else {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(max<map[i][j]) {
						max=map[i][j];
					}
				}
			}
			return max-1;
		}
	}
	
	public static boolean check() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					return true;
				}
			}
		}
		return false;
	}

}
