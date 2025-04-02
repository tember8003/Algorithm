import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String hamburger = br.readLine();
		boolean[] check = new boolean[N];
		int count=0;
		
		for(int i=0; i<N; i++) {
			char temp = hamburger.charAt(i);
			if(temp=='P') {
				for(int j=i-K; j<=i+K; j++) {
					if(j<0) {
						continue;
					}
					if(j>=N) {
						break;
					}
					if(hamburger.charAt(j)=='H' && !check[j]) {
						check[j]=true;
						count++;
						break;
					}
				}
			}
		}
		
		System.out.println(count);
	}

}
