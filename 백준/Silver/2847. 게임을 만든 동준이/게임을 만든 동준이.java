import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	//그리디 알고리즘 문제
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] num = new int[N];
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		int result=0;
		for(int i= N-1; i>=1; i--) {
			if(num[i] > num[i-1]) {
				continue;
			}
			else {
				while(true) {
					num[i-1]--;
					result++;
					
					if(num[i] > num[i-1]) {
						break;
					}
				}
			}
		}
		
		System.out.println(result);
	}
}
