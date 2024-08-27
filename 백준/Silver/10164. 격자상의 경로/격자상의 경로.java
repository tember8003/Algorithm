import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//dfs로 해결한 문제
	static int N,M,K;
	static int[][] map;
	static int[] dx = {1,0};
	static int[] dy = {0,1};
	static boolean[][] visited;
	static int ans=0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map= new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		
		int X=0; int Y=0;
		for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map[i][j] = (i - 1) * M + j;
                if (map[i][j] == K) {
                    X = i;
                    Y = j;
                }
            }
		}
		
		if(K==0) {
			dfs(1,1,N,M);
			System.out.println(ans);
		}
		else {
			dfs(1,1,X,Y);
			int first_ans = ans;
			ans=0;
			
			dfs(X,Y,N,M);
			int second_ans =ans;
			System.out.println(first_ans * second_ans);
		}
	}
	
	public static void dfs(int x,int y, int end_x, int end_y) {
		visited[x][y]=true;
		if(x==end_x && y==end_y) {
			ans++;
			return;
		}
		
		for(int i=0; i<2; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx> N || nx<=0 || ny>M || ny<=0) {
				continue;
			}
			if(visited[nx][ny]) {
				continue;
			}
			
			visited[nx][ny]=true;
			dfs(nx,ny,end_x,end_y);
			visited[nx][ny]=false;
		}
	}
}
