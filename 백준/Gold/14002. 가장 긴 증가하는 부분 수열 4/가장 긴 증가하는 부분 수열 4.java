import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	static int[] arr; //숫자 배열
	static int[] dp; //가장 긴 증가하는 부분 수열 길이 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		
		arr= new int[N+1];
		dp= new int[N+1];
		
		for(int i=0; i<N; i++) { //값 입력
			arr[i]=Integer.parseInt(st.nextToken());
			dp[i]=1; //길이 1로 설정
		}
		
		if(N==1) { //수열의 길이가 1이면 계산 의미없다.
			sb.append(1+"\n"); //출력값들 StringBuilder에 append
			sb.append(arr[0]);
		}
		else {
			for(int i=1; i<N; i++) {
				for(int j=0; j<i; j++) {
					if(arr[i]>arr[j]) { //만약 수열이 증가하는 경우라면?
						dp[i]=Math.max(dp[i], dp[j]+1); //더 긴 길이 찾기
					}
				}
			}
			int result=-1; //가장 긴 길이 찾기용
			Vector<Integer> vec = new Vector<Integer>();
			for(int i=0; i<N; i++) { //가장 긴 길이 찾기
				result=Math.max(result, dp[i]);
			}
			
			sb.append(result+"\n"); //길이 StringBuilder에 append
			int len= result; //가장 긴 길이 복사
			
			for(int i=N-1; i>=0; i--) { //역순으로 부분 수열 값 찾기
				//길이가 같은 dp 찾고 그때 숫자 배열을 Vector에 저장 후 len -1로 부분 수열 찾아간다.
				if(dp[i]==len) {
					vec.add(arr[i]);
					len--;
				}
				if(len==0) {
					break;
				}
			}
			
			for(int i=vec.size()-1; i>=0; i--) {
				sb.append(vec.get(i)+" "); //부분 수열들 StringBuilder에 append
			}
		}
		System.out.println(sb.toString());
	}
}
