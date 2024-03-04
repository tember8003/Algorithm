import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int count=0;
	static char[][] map;
	static boolean[][] visited;
	static int n;
	static int m;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		n= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());
		
		visited=new boolean[n][m];
		map=new char[n][m];
		
		for(int i=0; i<n; i++) {
			String temp=br.readLine();
			map[i]=temp.toCharArray();
		}
		int start_x=0; int start_y=0;
		for(int i=0; i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]=='I') {
					start_x=j;
					start_y=i;
				}
			}
		}
		dfs(start_x,start_y);
		if(count==0) {
			System.out.println("TT");
		}
		else {
			System.out.println(count);
		}
		
	}
	public static void dfs(int x,int y) {
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0 || ny<0|| nx>=m|| ny>=n) {
				continue;
			}
			if(map[ny][nx]=='X' || visited[ny][nx]) {
				continue;
			}
			if(!visited[ny][nx] && map[ny][nx]=='O') {
				visited[ny][nx]=true;
				dfs(nx,ny);
			}
			if(!visited[ny][nx] && map[ny][nx]=='P') {
				visited[ny][nx]=true;
				count++;
				dfs(nx,ny);
			}
		}
		return;
	}
}
