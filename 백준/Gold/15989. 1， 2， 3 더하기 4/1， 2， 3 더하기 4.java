import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[][] dp= new long[10001][4];
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp[1][1]=1;
		dp[2][1]=1; dp[2][2]=1;
		dp[3][1]=1; dp[3][2]=1; dp[3][3]=1;
		for(int i=4; i<=10000; i++) {
			dp[i][1]=1;
			dp[i][2]=dp[i-2][1]+dp[i-2][2];
			dp[i][3]=dp[i-3][1]+dp[i-3][2]+dp[i-3][3];
		}
		for(int i=0; i<n; i++) {
			int t = Integer.parseInt(br.readLine());
			long temp = dp[t][1]+dp[t][2]+dp[t][3];
			System.out.println(temp);
		}
	}
}
