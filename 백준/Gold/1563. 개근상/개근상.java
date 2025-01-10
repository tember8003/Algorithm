import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	//3차원 배열을 사용하는 DP 문제
	static int NUM = 1000000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][][] dp = new int[N+1][2][3]; //일수 / 지각 / 결석
		dp[1][0][0]=1;
		dp[1][1][0]=1;
		dp[1][0][1]=1;
		
		for(int i=2; i<=N; i++) {
			dp[i][0][0] = (dp[i-1][0][1] + dp[i-1][0][0] + dp[i-1][0][2]) % NUM;
			dp[i][0][1] = dp[i-1][0][0] % NUM;
			dp[i][0][2] = dp[i-1][0][1] % NUM;
			dp[i][1][0] = (dp[i-1][0][0]+dp[i-1][0][1]+dp[i-1][0][2]+dp[i-1][1][0]+dp[i-1][1][1]+dp[i-1][1][2]) % NUM;
			dp[i][1][1] = dp[i-1][1][0] % NUM;
			dp[i][1][2] = dp[i-1][1][1] % NUM;
		}
		
		int result = (dp[N][0][0]+dp[N][0][1]+dp[N][0][2]+dp[N][1][0]+dp[N][1][1]+dp[N][1][2]) % NUM;
		
		System.out.println(result);
	}
}
