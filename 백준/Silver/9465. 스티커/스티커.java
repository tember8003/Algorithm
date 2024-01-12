import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int n;
		StringTokenizer st;
		for(int i=0; i<t; i++) {
			n=Integer.parseInt(br.readLine());
			int[][] map = new int[2][n+1];
			int[][] dp = new int[2][n+1];
			for(int j=0; j<2; j++) {
				String[] inputs = br.readLine().split(" ");
				for(int k=1; k<=n; k++) {
					map[j][k]=Integer.parseInt(inputs[k-1]);
				}
			}
			dp[0][1]=map[0][1];
			dp[1][1]=map[1][1];
			for(int j=2; j<=n; j++) {
				dp[0][j]=Math.max(dp[1][j-1],Math.max(dp[1][j-2],dp[0][j-2]))+map[0][j];
				dp[1][j]=Math.max(dp[0][j-1],Math.max(dp[0][j-2],dp[1][j-2]))+map[1][j];
			}
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}
}
