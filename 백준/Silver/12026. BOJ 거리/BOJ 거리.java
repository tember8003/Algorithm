import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	//dp 문제
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		char[] BOJ = new char[n]; //BOJ 문자 배열
		BOJ = br.readLine().toCharArray();
		
		long[] dp = new long[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[0]=0;
		
		for(int i=0; i<n-1; i++) { // B -> 0 -> J 순으로 탐색
			char word = BOJ[i];
			if(word=='B') {
				for(int j=i+1; j<n; j++) {
					char next_word = BOJ[j];
					if(next_word=='O') {
						dp[j] = (long) Math.min(dp[j], (dp[i]+ Math.pow(i-j, 2)));
					}
				}
			}
			else if(word=='O') {
				for(int j=i+1; j<n; j++) {
					char next_word = BOJ[j];
					if(next_word=='J') {
						dp[j] = (long) Math.min(dp[j], (dp[i]+ Math.pow(i-j, 2)));
					}
				}
			}
			else {
				for(int j=i+1; j<n; j++) {
					char next_word = BOJ[j];
					if(next_word=='B') {
						dp[j] = (long) Math.min(dp[j], (dp[i]+ Math.pow(i-j, 2)));
					}
				}
			}
		}
		
		if(dp[n-1]==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(dp[n-1]);
		}
	}
}
