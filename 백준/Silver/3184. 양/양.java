import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static boolean[][] visited;
	
	static int R;
	static int C;
	
	static int total_sheep=0;
	static int total_wolves=0;
	
	static int sheep=0;
	static int wolves=0;
	
	static int[] dx= {0,0,-1,1};
	static int[] dy= {-1,1,0,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		visited=new boolean[R][C];
		
		/*
		for(int i=0; i<R; i++) {
			String temp = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j]=temp.charAt(j);
			}
		}
		*/
		
		for(int i=0; i<R; i++) {
			map[i]=br.readLine().toCharArray();
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if((map[i][j]=='v' || map[i][j]=='o') && !visited[i][j]) {
					sheep=0;
					wolves=0;
					DFS(i,j);
					if(sheep > wolves) {
						total_sheep+=sheep;
					}
					else {
						total_wolves+=wolves;
					}
				}
			}

		}
		System.out.println(total_sheep + " "+ total_wolves);
	}
	
	public static void DFS(int x,int y) {
		visited[x][y]=true;
		if(map[x][y]=='v') {
			wolves++;
		}
		else if(map[x][y]=='o') {
			sheep++;
		}
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0 || nx>=R || ny<0 || ny>=C) {
				continue;
			}
			if(map[nx][ny]=='#'|| visited[nx][ny]) {
				continue;
			}
			visited[nx][ny]=true;
			DFS(nx,ny);
		}
		return;
	}
}
