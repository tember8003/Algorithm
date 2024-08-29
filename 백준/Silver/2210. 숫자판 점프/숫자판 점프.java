import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	//DFS 문제
	static int[][] arr = new int[6][6];
	static Set<String> sets = new HashSet<String>();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=1; i<=5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				DFS(i,j,"");
			}
		}
		
		System.out.println(sets.size());
	}
	
	public static void DFS(int x,int y,String num) {
		if(num.length()==6) {
			sets.add(num);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >5 || nx<1 || ny>5 || ny<1) {
				continue;
			}
			
			DFS(nx,ny,num+Integer.toString(arr[nx][ny]));
		}
	}
}
