import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//브루트포스 알고리즘 문제 - 규칙 찾기
	static int N,Kim,Im;
	static int round=0;
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			Kim = Integer.parseInt(st.nextToken());
			Im = Integer.parseInt(st.nextToken());
			
			while(Kim!=Im) {
				Kim = Kim/2+Kim%2;
				Im = Im/2+Im%2;
				round++;
			}
			
			System.out.println(round);
		}
}
