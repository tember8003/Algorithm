import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr=new int[100002];
	static int[] hap=new int[100002];

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		int n =Integer.parseInt(br.readLine());
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			hap[i]=hap[i-1]+arr[i];
		}
		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			sb.append(hap[num2]-hap[num1-1]+"\n");
		}
		System.out.println(sb.toString());
	}

}
