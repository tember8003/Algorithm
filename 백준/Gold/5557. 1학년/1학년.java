import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//DP 문제
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		long[][] dp = new long[N][21];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][arr[0]]=1;
		
		for(int i=1; i<N-1; i++) { //배낭문제와 비슷
			for(int j=0; j<=20; j++) {
				if(dp[i-1][j]!=0) {
					int plus = j+arr[i];
					int minus = j-arr[i];
					if(plus<=20 && plus>=0) {
						dp[i][plus]+=dp[i-1][j];
					}
					if(minus>=0 && minus<=20) {
						dp[i][minus]+=dp[i-1][j];
					}
				}
			}
		}
		
		System.out.println(dp[N-2][arr[N-1]]); 
		//마지막 숫자 사이에 = 넣으므로 사실상 N-2까지 숫자를 가지고 DP를 돌려야 함.	
	}
}
