import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int t;
		StringTokenizer st;
		for(int i=0;i<n; i++) {
			t=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			arr=new int[t+1];
			dp = new int[t+1];
			int max_result=Integer.MIN_VALUE;
			for(int j=1; j<=t; j++) {
				arr[j]=Integer.parseInt(st.nextToken());
			}
			for(int j=1; j<=t; j++) {
				dp[j]=Math.max(0,dp[j-1])+arr[j];
				max_result=Math.max(dp[j], max_result);
			}
			System.out.println(max_result);
		}
	}
}
