import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//브루트포스 문제
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		int hap = 0;
		int[] card = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			for(int j= i+1; j<N; j++) {
				for(int k= j+1; k<N; k++) {
					sum = card[i] + card[j] + card[k];
					if(sum > hap && sum <= M) {
						hap=sum;
					}
				}
			}
		}
		
		
		System.out.println(hap);
	}
}
