import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int dp[] = new int[1001];
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp[1]=0; // 0 은 창영이 이긴다.
		dp[2]=1; // 1 은 상근이 이긴다.
		dp[3]=0;
		dp[4]=1;
		for(int i=5; i<=1000; i++) {
			if(dp[i-1]+dp[i-3]+dp[i-4]==3) {
				dp[i]=0;
			}
			else {
				dp[i]=1;
			}
		}
		if(dp[n]==1) {
			System.out.println("SK");
		}
		else {
			System.out.println("CY");
		}
	}

}
