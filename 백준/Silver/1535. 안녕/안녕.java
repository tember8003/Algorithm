import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//dp 문제
	static int k=99;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] hp = new int[n+1]; //체력
		int[] happy = new int[n+1]; //기쁨
		int[][] dp = new int[n+1][k+1]; //체력 99까지 [사람 수][체력]
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			hp[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			happy[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=k; j++) {
				if(hp[i] > j) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-hp[i]]+happy[i]);
				}
			}
		}
		
		System.out.println(dp[n][k]);
	}
}
