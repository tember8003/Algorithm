import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	//플로이드 알고리즘 사용
	static int INF = 99999999;
	static int N,M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][N+1];
		StringTokenizer st;
		
		for(int i=1; i<=N; i++) {//초기화 작업 ([시작][끝]) 형식
			for(int j=1; j<=N; j++) {
				arr[i][j] = INF;
				
				if(i==j) { //만약 [1][1] 같은 경우, 시작이 1이고 끝이 1이면 같은 자리이다.
					arr[i][j]=0;
				}
			}
		}
			
		
		for(int i=0; i<M; i++) {//최소 길이를 찾아야 하므로 min 을 통해 값이 작은 것을 우선시함.
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			arr[start][end] = Math.min(arr[start][end],cost);
		}
		
		for(int i=1; i<=N; i++) { //플로이드 알고리즘 수행
			for(int j=1; j<=N; j++) {
				for(int k=1; k<=N; k++) {
					if(arr[j][k] > arr[j][i] + arr[i][k]) {
						arr[j][k] = arr[j][i] + arr[i][k];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder(); //각각의 최단거리 저장하기
		for (int i=1; i<=N; i++) { 
			for(int j=1; j<=N; j++) {
				if(arr[i][j]==INF) {
					arr[i][j]=0;
				}
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		
		
		System.out.println(sb.toString()); //출력하기
	}

}
