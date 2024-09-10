import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//그리디 알고리즘 문제
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());//배열 수
			
			int[] num = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {//입력 받기
				num[j] = Integer.parseInt(st.nextToken());
			}
			
			int max_num = num[N-1]; //최대 이익 수
			long result = 0;
			
			//만약 이익이 생길 수 있다면 이익 구하기 아니면 최대 이익 수 갱신
			for(int j = N-2; j>=0; j--) {
				if(max_num < num[j]) {
					max_num = num[j];
				}
				else {
					result += max_num - num[j];
				}
			}
			
			sb.append(result+"\n");
		}
		
		System.out.println(sb.toString());
	}
}
