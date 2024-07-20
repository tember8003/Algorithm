import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int mod = 1000000009;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp;
		if(N==1) {
			System.out.println(0);
		}
		else {
			dp = new long[N+1];
			dp[2]=2;
			for(int i=3; i<=N; i++) {
				dp[i]=(dp[i-1]*3)%mod;
			}
			System.out.println(dp[N]);
		}
	}
}
