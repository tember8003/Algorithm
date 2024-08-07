import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //백트래킹 문제
	static long[][] taste;
	static long ans=Long.MAX_VALUE;
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		taste = new long[n][2];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			taste[i][0]=Integer.parseInt(st.nextToken());
			taste[i][1]=Integer.parseInt(st.nextToken());
		}
		
		backtracking(0,1,0,0);
		System.out.println(ans);
	}
	public static void backtracking(int cnt,long sour, long bitter,int select) {
		if(cnt==n) {
			if(select!=0 && Math.abs(sour - bitter)<ans) {
				ans = Math.abs(sour - bitter);
			}
			return;
		}
		
		//두가지 경우 - cnt번 재료를 사용할 것인지 아닌지
		backtracking(cnt+1,sour*taste[cnt][0],bitter+taste[cnt][1],select+1);
		backtracking(cnt+1,sour,bitter,select);
	}
}
