import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//문제 의도: 열외해야 하는 병사의 수를 직접적으로 구하는 것이 아닌, 전체에서 정상 병사의 수를 빼서 계산
	static int size; //병사의 수
	static long[] dp;
	static long[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		size=Integer.parseInt(br.readLine());
		dp=new long[size+1];
		arr=new long[size+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		//병사 배열 + dp 배열 설정
		
		for(int i=1;i<=size; i++) { //병사 전투력 입력 + dp 1 입력
			arr[i]=Integer.parseInt(st.nextToken());
			dp[i]=1;
		}
		
		for(int i=1; i<=size; i++) {
			for(int j=1; j<i; j++) {
				if(arr[i]<arr[j]) {//예를 들어 3번째 값보다 4번째 값이 더 작다면? ->정상이라면?
					dp[i]=Math.max(dp[i],dp[j]+1 );//dp값 더 큰거 고르기
				}
			}
		}
		long max_dp=0;
		for(int i=1; i<=size; i++) {
			if(dp[i]> max_dp) {
				max_dp=dp[i];//가장 큰 dp값 찾기
			}
		}
		System.out.println(size-max_dp);//전체 - 정상적인 병사 수 = 열외해야 하는 병사 수
	}
}
