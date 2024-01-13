import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] ars) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		int[] arr= new int[n+1];
		int[] dp= new int[n+1];
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			dp[i]=1;
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<i; j++) {
				if(arr[i]>arr[j]) {
					dp[i]=Math.max(dp[j]+1, dp[i]);
				}
			}
		}
		
		Arrays.sort(dp);
		System.out.println(dp[n]);
	}
}
