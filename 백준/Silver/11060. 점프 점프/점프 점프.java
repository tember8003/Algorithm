import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr = new int[1101];
	static int[] dp= new int[1101];
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
			dp[i]=Integer.MAX_VALUE;
		}
		dp[1]=0;
		for(int i=1; i<=n; i++) {
			int jump=arr[i];
			for(int j=1; j<=jump; j++) {
				if(dp[i]!=Integer.MAX_VALUE) {
					dp[i+j]=Math.min(dp[i]+1, dp[i+j]);
				}
			}
		}
		if(dp[n]==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(dp[n]);
		}
	}
}
