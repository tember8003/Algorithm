import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	//dp문제 - 이거 실버 3 아님 진짜로
	static int N,M;
	static int[][] map;
	static int[][][] dp;
	static int MAX = 987654321;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		dp = new int[N+1][M+1][3];
		int result = MAX;
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				Arrays.fill(dp[i][j], MAX);
			}
		}
		
		for(int i=1; i<=M; i++) {
			dp[1][i][0] = map[1][i];
			dp[1][i][1] = map[1][i];
			dp[1][i][2] = map[1][i];
		}
		for(int i=2; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(j==1) {
					dp[i][j][0]=Math.min(dp[i-1][j+1][1],dp[i-1][j+1][2])+map[i][j];
					dp[i][j][1]=dp[i-1][j][0]+map[i][j];
				}
				else if(j==M) {
					dp[i][j][1]=dp[i-1][j][2]+map[i][j];
					dp[i][j][2]=Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1])+map[i][j];
				}
				else {
					dp[i][j][0]=Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2])+map[i][j];
					dp[i][j][1]=Math.min(dp[i-1][j][0], dp[i-1][j][2])+map[i][j];
					dp[i][j][2]=Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1])+map[i][j];
				}
			}
		}
		for(int i=1; i<=M; i++) {
			for(int j=0; j<3; j++) {
				result = Math.min(result, dp[N][i][j]);	
			}
		}
		System.out.println(result);
	}
}
