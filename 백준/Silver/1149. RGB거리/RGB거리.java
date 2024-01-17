import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp=new int[1001][3];
	static int[] arr=new int[1001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		for(int i=1; i<=n; i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				arr[j]=Integer.parseInt(st.nextToken());
			}
			dp[i][0]=Math.min(dp[i-1][1], dp[i-1][2])+arr[0];
			dp[i][1]=Math.min(dp[i-1][0], dp[i-1][2])+arr[1];
			dp[i][2]=Math.min(dp[i-1][0], dp[i-1][1])+arr[2];
		}
		int ans = Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
		System.out.println(ans);
	}

}
