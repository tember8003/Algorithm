import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dp1=new int[1001];
	static int[] dp2=new int[1001];
	static int[] arr=new int[1001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans=0;
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			dp1[i]=1;
			dp2[i]=1;
		}
		for(int i=1; i<=n; i++) {
			for(int j=i+1; j<=n; j++) {
				if(arr[i]<arr[j]) {
					dp1[j]=Math.max(dp1[i]+1, dp1[j]);
				}
			}
		}
		for(int i=n; i>0; i--) {
			for(int j=i-1; j>0; j--) {
				if(arr[i]<arr[j]) {
					dp2[j]=Math.max(dp2[i]+1, dp2[j]);
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			ans=Math.max(ans,dp1[i]+dp2[i]-1);
		}
		System.out.println(ans);
	}

}
