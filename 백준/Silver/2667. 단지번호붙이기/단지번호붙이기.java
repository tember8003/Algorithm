import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<Integer> result;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static int count=0;
	static int cnt=1;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		result = new LinkedList<Integer>();
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					count++;
					DFS(i,j);
					result.add(cnt);
				}
				cnt=1;
			}
		}
		
		System.out.println(count);
		
		Collections.sort(result);
		for(int i = 0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	
	public static void DFS(int x,int y) {
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny <0 || nx>=N || ny>=N) { //범위 벗어날 경우
				continue;
			}
			
			if(!visited[nx][ny] && map[nx][ny]==1) {
				cnt++;
				visited[nx][ny]=true;
				DFS(nx,ny);
			}
		}
	}
}
