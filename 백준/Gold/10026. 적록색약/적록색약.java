import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static char[][] map;
	static boolean[][] visited;
	static int[] dy= {-1,1,0,0};
	static int[] dx= {0,0,-1,1};
	static int cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		map=new char[n][n];
		visited=new boolean[n][n];
		String temp;
		for(int i=0; i<n; i++) {
			temp=br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j]= temp.charAt(j);
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					cnt++;
				}
			}
		}
		
		sb.append(cnt+" ");
		cnt=0;
		visited=new boolean[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]=='G') {
					map[i][j]='R';
				}
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					cnt++;
				}
			}
		}
		sb.append(cnt);
		System.out.println(sb.toString());
	}
	public static void dfs(int x,int y) {
		visited[x][y]=true;
		char temp=map[x][y];
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0 || ny<0|| nx>=n || ny>=n) {
				continue;
			}
			if(!visited[nx][ny] && map[nx][ny]==temp) {
				dfs(nx,ny);
			}
		}
	}
}
