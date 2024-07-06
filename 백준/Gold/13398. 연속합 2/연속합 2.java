import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//DP 문제
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] dp_front = new int[n]; //앞에서부터 누적시킬 DP
		int[] dp_end = new int[n]; //뒤에서부터 누적시킬 DP
		int[] arr = new int[n]; //배열
		
		StringTokenizer st =new StringTokenizer(br.readLine()); //입력받기
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		dp_front[0] = arr[0];
		int ans=dp_front[0];
		for(int i=1; i<n; i++) { //앞에서부터 최대 계산
			dp_front[i] = Math.max(dp_front[i-1]+arr[i], arr[i]);
			
			ans = Math.max(ans, dp_front[i]);
		}
		
		dp_end[n-1]=arr[n-1];
		for(int i=n-2; i>=0; i--) { //뒤에서부터 최대 계산 
			dp_end[i]=Math.max(dp_end[i+1]+arr[i], arr[i]);
		}
		
		for(int i=1; i<n-1; i++) {//ANS가 최대 VS 중간에 숫자 하나 지우고 계산한 것이 최대인지 판별
			ans = Math.max(ans, (dp_front[i-1]+dp_end[i+1]));
		}
		System.out.println(ans);	
	}
}
