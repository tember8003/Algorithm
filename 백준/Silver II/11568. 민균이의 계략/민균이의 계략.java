import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] arr= new long[1001];
	static long[] dp= new long[1001];
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i]=Long.parseLong(st.nextToken());
			dp[i]=1;
		}
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(arr[i]<arr[j]) {
					dp[j]=Math.max(dp[j], dp[i]+1);
				}
			}
		}
		long result=0;
		for(int i=0; i<n; i++) {
			result=Math.max(result,dp[i]);
		}
		System.out.println(result);
	}
}
