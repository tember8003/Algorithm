import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dp=new int[1000001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		dp[1]=1; dp[2]=2; dp[3]=3;
		if(n<=3) {
			System.out.println(dp[n]);
		}
		else {
			for(int i=4; i<=n; i++) {
				dp[i]=(dp[i-1]+dp[i-2])%15746;
			}
			System.out.println(dp[n]);
		}
		

	}

}
