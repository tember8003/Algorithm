import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[] dp = new long[2000001];
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine())+1000000;
		dp[1000000]=0; //F[0]
		dp[1000001]=1; //F[1]
		if(n<1000000) {
			for(int i=999999; i>=n; i--) {
				dp[i]=(dp[i+2]-dp[i+1])%1000000000;
			}
		}
		else {
			for(int i=1000002; i<=n; i++) {
				dp[i]=(dp[i-1]+dp[i-2])%1000000000;
			}
		}
		
		if(dp[n]>0) {
			System.out.println(1);
		}
		else if(dp[n]==0) {
			System.out.println(0);
		}
		else {
			System.out.println(-1);
		}
		System.out.println(Math.abs(dp[n]));
	}

}
