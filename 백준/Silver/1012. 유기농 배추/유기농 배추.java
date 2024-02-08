import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int[] dy= {0,0,-1,1};
	static int[] dx= {-1,1,0,0};
	static int M;
	static int N;
	static int K;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); //가로
			N = Integer.parseInt(st.nextToken()); //세로
			K = Integer.parseInt(st.nextToken()); //1인 위치
			map= new int[M][N]; //가로 세로
			visited = new boolean[M][N];
			ans=0;
			
			for(int j=0; j<K; j++) {
				st= new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y]=1;
			}
			
			for(int j=0; j<M; j++) {
				for(int k=0; k<N; k++) {
					if(map[j][k]==1 && !visited[j][k]) {
						dfs(j,k);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}
	public static void dfs(int x,int y) {
		visited[x][y]=true;
		for(int i=0; i<4; i++) {
			int temp_x = x+dx[i];
			int temp_y = y+dy[i];
			if(temp_x>=0 && temp_y>=0 && temp_x<M && temp_y<N) {
				if(map[temp_x][temp_y]==1 && !visited[temp_x][temp_y]) {
					dfs(temp_x,temp_y);
				}
			}
		}
	}
}
