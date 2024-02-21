import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dp=new int[20];
	static int[] day=new int[20];
	static int[] pay =new int[20];
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=1; i<=n; i++) {
			st=new StringTokenizer(br.readLine());
			day[i]=Integer.parseInt(st.nextToken());
			pay[i]=Integer.parseInt(st.nextToken());
		}
		int last;
		for(int i=n; i>0; i--) {
			last=i+day[i];
			if(last>n+1) {
				dp[i]=dp[i+1];
			}
			else {
				dp[i]=Math.max(dp[i+1], dp[last]+pay[i]);
			}
		}
		System.out.println(dp[1]);
	}
}
