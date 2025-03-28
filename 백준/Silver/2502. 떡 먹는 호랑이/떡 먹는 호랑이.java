import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//DP 문제
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[D];
		
		for(int i=1; i<=K/2; i++) {
			for(int j=i; j<K; j++) {
				dp[0]=i;
				dp[1]=j;
				for(int k=2; k<D; k++) {
					dp[k] = dp[k-1]+dp[k-2];
				}
				if(dp[D-1]==K) {
					System.out.println(dp[0]);
					System.out.println(dp[1]);
					System.exit(0);
				}
			}
		}
	}
}
