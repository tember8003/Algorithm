import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] map;
	static boolean[][] visited;
	static int result=1;
	static int[] dy= {0,0,-1,1};
	static int[] dx= {-1,1,0,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		n= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		map= new int[n+1][m+1];
		visited=new boolean[n+1][m+1];
		int result_max=0;
		for(int i=0; i<k; i++) {
			st=new StringTokenizer(br.readLine());
			int temp_n = Integer.parseInt(st.nextToken());
			int temp_m = Integer.parseInt(st.nextToken());
			map[temp_n][temp_m]=1;
		}
		for(int i=1;i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(!visited[i][j]&&map[i][j]==1) {
					result=1;
					dfs(i,j);
					result_max=Math.max(result_max, result);
				}
			}
		}
		System.out.println(result_max);
	}
	public static void dfs(int x,int y) {
		visited[x][y]=true;
		for(int i=0; i<4; i++) {
			int temp_x=x+dx[i];
			int temp_y=y+dy[i];
			if(temp_x<1 || temp_y<1||temp_x>n||temp_y>m) {
				continue;
			}
			if(map[temp_x][temp_y]==1 && !visited[temp_x][temp_y]) {
				result++;
				dfs(temp_x,temp_y);
			}
		}
		return;
	}
}
