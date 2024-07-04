import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] dp1 = new int[n+1][3]; //최댓값 계산용
		int[][] dp2 = new int[n+1][3]; //최솟값 계산용
		
		for(int i=1; i<=n; i++) { //각각 숫자 입력
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				int num = Integer.parseInt(st.nextToken());
				dp1[i][j]=num;
				dp2[i][j]=num;
			}
		}
		
		for(int i=n; i>=2; i--) {//최댓값 찾기
			dp1[i-1][0] += Math.max(dp1[i][0], dp1[i][1]);
			dp1[i-1][1] += Math.max(dp1[i][0], Math.max(dp1[i][1],dp1[i][2]));
			dp1[i-1][2] += Math.max(dp1[i][1], dp1[i][2]);
		}
		
		for(int i=n; i>=2; i--) {//최솟값 찾기
			dp2[i-1][0] += Math.min(dp2[i][0], dp2[i][1]);
			dp2[i-1][1] += Math.min(dp2[i][0], Math.min(dp2[i][1],dp2[i][2]));
			dp2[i-1][2] += Math.min(dp2[i][1], dp2[i][2]);
		}
		
		int max_num = Math.max(dp1[1][0], Math.max(dp1[1][1], dp1[1][2])); //최댓값 계산
		int min_num = Math.min(dp2[1][0], Math.min(dp2[1][1], dp2[1][2])); //최댓값 계산
		
		System.out.println(max_num +" "+min_num);	
	}
}
