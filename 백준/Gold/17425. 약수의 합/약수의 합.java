import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[] hap =new long[1000002];
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		for(int i=1; i<=1000001; i++) {
	        for(int j = i; j <= 1000001; j+=i){
	            hap[j] += i;
	        }
		}
		for(int i=1; i<=1000001; i++) {
			hap[i]+=hap[i-1];
		}
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			int temp = Integer.parseInt(br.readLine());
			sb.append(hap[temp]+"\n");
		}
		System.out.println(sb.toString());
	}
}
