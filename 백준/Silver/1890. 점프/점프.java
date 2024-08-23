import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //dp 문제
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n+1][n+1];
		long[][] dp = new long[n+1][n+1];
		dp[1][1]=1;
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				int cnt = map[i][j];
				if(cnt==0) {
					break;
				}
				if(i+cnt<=n) {
					dp[i+cnt][j] += dp[i][j];
				}
				if(j+cnt<=n) {
					dp[i][j+cnt] += dp[i][j];
				}
			}
		}
		
		System.out.println(dp[n][n]);
	}
}
