import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int map[][];
	static boolean visited[]= new boolean[20];
	static int Min=Integer.MAX_VALUE;
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map=new int[n][n];
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(Min);
	}
	public static void dfs(int cnt,int idx) {
		if(cnt==n/2) {
			gap();
			return;
		}
		for(int i=idx; i<n; i++) {
			if(visited[i]) {
				continue;
			}
			visited[i]=true;
			dfs(cnt+1,i+1);
			visited[i]=false;
		}
	}
	public static void gap() {
		int start=0;
		int link=0;
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(visited[i]==true && visited[j]==true) {
					start+=map[i][j];
					start+=map[j][i];
				}
				else if(visited[i]==false && visited[j]==false) {
					link+=map[i][j];
					link+=map[j][i];
				}
			}
		}
		int val = Math.abs(start-link);
		if(val==0) {
			System.out.println(val);
			System.exit(0);
		}
		Min=Math.min(val, Min);
	}

}
