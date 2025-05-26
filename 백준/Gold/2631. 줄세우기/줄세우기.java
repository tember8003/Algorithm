import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n];
		int[] arr = new int[n];
		
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
		}
		
		Arrays.fill(dp, 1);
		
		int ans=0;
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(arr[j]<arr[i]) {
					dp[i]= Math.max(dp[i], dp[j]+1);
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(n - ans);
	}

}