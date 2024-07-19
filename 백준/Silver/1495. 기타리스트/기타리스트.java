import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//DP 문제
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //입력 받기
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] dp = new boolean[N+1][M+1]; //DP배열 [곡의 개수][최대 볼륨]
		int[] V = new int[N+1]; //볼륨 배열
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][S]=true; //초기 시작 TRUE
        
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=M; j++) {
				if(dp[i-1][j]) {
					int max_value = j + V[i]; // +일 때
					int min_value = j - V[i]; // -일 때
					if(min_value>=0) {
						dp[i][min_value]=true;
					}
					if(max_value<=M) {
						dp[i][max_value]=true;
					}
				}
			}
		}
        
		int ans=-1;
		for(int i=M; i>=0; i--) {
			if(dp[N][i]) {
				ans=i;
				break;
			}
		}
		System.out.println(ans);
	}
}
	