import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr = new int[100001];
	static int[] dp = new int[100001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result=-123456789;
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<=n; i++) {
			dp[i]=Math.max(dp[i-1]+arr[i], arr[i]);
			result=Math.max(dp[i], result);
		}
		System.out.println(result);
	}
}
