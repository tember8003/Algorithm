import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int[][] map;
	static int result=0;
	static int w,h;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		while(true) {
			result=0;
			st=new StringTokenizer(br.readLine());
			w=Integer.parseInt(st.nextToken());
			h=Integer.parseInt(st.nextToken());
			if(w==0 && h==0) {
				break;
			}
			
			visited=new boolean[h][w];
			map=new int[h][w];
			
			for(int i=0; i<h; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(!visited[i][j] && map[i][j]==1) {
						dfs(i,j);
						result++;
					}
				}
			}
			sb.append(result+"\n");
		}
		System.out.println(sb.toString());
	}
	public static void dfs(int x,int y) {
		visited[x][y]=true;
		for(int i=0; i<8; i++) {
			int temp_x=x+dx[i];
			int temp_y=y+dy[i];
			if(temp_x<0 || temp_y<0|| temp_x>=h || temp_y>=w) {
				continue;
			}
			if(map[temp_x][temp_y]==1 && !visited[temp_x][temp_y]) {
				dfs(temp_x,temp_y);
			}
		}
	}
}


