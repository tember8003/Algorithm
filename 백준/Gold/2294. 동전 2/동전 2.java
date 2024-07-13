import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//dp문제
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int[] dp=new int[k+1];
		int[] arr=new int[k+1];
		dp[0]=0; 
		
		for(int i=1; i<=n; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		for(int i=1; i<=k; i++) { //dp 배열 동전 개수 최대로
			dp[i]=Integer.MAX_VALUE -1;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=arr[i]; j<=k; j++) { //동전 개수 더 작은거로 줄여나가기
				dp[j]=Math.min(dp[j], dp[j-arr[i]]+1);
			}
		}
		if(dp[k]==Integer.MAX_VALUE-1) {//만약 동전으로 k를 못만든다면
			System.out.println(-1);
		}
		else {
			System.out.println(dp[k]);
		}
	}
}
