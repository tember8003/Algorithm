import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//문자열 문제
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String str = br.readLine();

		int ans=0;
		int count=0;
		
		for(int i=1; i<m-1; i++) {
			if(str.charAt(i-1)=='I' && str.charAt(i)=='O' && str.charAt(i+1)=='I') {
				count++;
				
				if(count == n) {
					count--;
					ans++;
				}
				i++;
			}
			else {
				count=0;
			}
		}
		
		System.out.println(ans);
	}
}
