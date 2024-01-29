import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] hap = new int[10002];
	static int[] arr = new int[10002];
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int ans=0;
		for(int i=1; i<=n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			hap[i]=hap[i-1]+arr[i];
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=i; j<=n; j++) {
				if(hap[j]-hap[i-1]==m) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}

}
