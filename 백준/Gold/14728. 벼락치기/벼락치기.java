import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	//dp - 배낭문제
	static int N,T; //단원 개수 , 총 시간
	static int[][] item; //단원 별 예상 공부 시간과 배점을 담은 배열
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		item = new int[N+1][2];
		dp = new int[N+1][T+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			item[i][0]=Integer.parseInt(st.nextToken()); //단원 별 예상 공부 시간
			item[i][1]=Integer.parseInt(st.nextToken()); //배점
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=T; j++) {
				if(item[i][0] > j) { //만약 현재 시간보다 예상 공부 시간이 더 크다면?
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-item[i][0]]+item[i][1]);
				}
			}
		}
		
		System.out.println(dp[N][T]);
	}
}
