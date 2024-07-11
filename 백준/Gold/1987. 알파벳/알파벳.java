import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//dfs 문제
	static boolean[] visited=  new boolean[26]; //같은 알파벳 체크 여부 확인
	static int map[][]; //입력 배열
	static int R,C; //크기
	static int[] dx = {1,-1,0,0}; //동서남북 이동
	static int[] dy = {0,0,1,-1};
	static int ans=0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		
		for(int i=0; i<R; i++) {
			String temp = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j]=temp.charAt(j)-'A';
			}
		}
		
		dfs(0,0,0);
		
		if(ans==0) { //처음 무조건 하나는 방문한다.
			ans=1;
		}
		System.out.println(ans);
	}
	
	public static void dfs(int x,int y, int cnt) {
		if(visited[map[x][y]]) { //같은 알파벳이 이미 방문했다면
			ans = Math.max(ans, cnt);
			return;
		}
		visited[map[x][y]]=true; 
			
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=R || ny >=C || nx<0 || ny <0) {
				continue;
			}
			dfs(nx,ny,cnt+1);
		}
		visited[map[x][y]]=false;	
	}
}
