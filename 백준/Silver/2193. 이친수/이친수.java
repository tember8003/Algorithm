import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static long[][] dp; //맨 뒷자리가 1 혹은 0인 2차원 배열
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp=new long[N+1][2];
		
		dp[1][1]=1; dp[1][0]=0; //1,0
		
		for(int i=2; i<=N; i++) {
			dp[i][0]=dp[i-1][1]+dp[i-1][0];
			dp[i][1]=dp[i-1][0];
		}
		System.out.println(dp[N][0]+dp[N][1]);
	}

}
