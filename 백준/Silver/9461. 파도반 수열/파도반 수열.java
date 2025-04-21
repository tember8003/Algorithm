import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		long[] dp = new long[110];
		dp[1]=1; dp[2]=1; dp[3]=1;
		
		int T = Integer.parseInt(br.readLine());
		for(int i=4; i<=105; i++) {
			dp[i]=dp[i-2]+dp[i-3];
		}
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(dp[N]);
		}
	}

}
