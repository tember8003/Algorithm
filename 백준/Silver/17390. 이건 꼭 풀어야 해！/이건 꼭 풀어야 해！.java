import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		StringBuilder sb =new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int[] arr =new int[n+1];
		arr[0]=0;
		for(int i=1; i<=n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		long[] hap = new long[n+1];
		for(int i=0; i<=n; i++) {
			if(i==0) {
				hap[i]=arr[i];
			}
			else {
				hap[i]=arr[i]+hap[i-1];
			}
		}
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			sb.append(hap[num2]-hap[num1-1]+"\n");
		}
		System.out.println(sb.toString());
	}
}
