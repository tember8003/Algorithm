import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] arr;
	static int INF= 999999999;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1];
		
		//초기화 작업
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				//친구 관계가 아직 입력 안되었으므로 무한대로 초기화한다.
				arr[i][j]=INF; //Integer.MAX_VALUE로 잡게 되면 오류 발생
				
				if(i==j) {
					arr[i][j]=0; //본인인 경우
				}
			}
		}
		int friend_1,friend_2;
		for(int i=0; i<m; i++) { //친구 관계 입력
			st=new StringTokenizer(br.readLine());
			friend_1=Integer.parseInt(st.nextToken());
			friend_2=Integer.parseInt(st.nextToken());
			
			arr[friend_1][friend_2]=1; //친구끼리는 1단계
			arr[friend_2][friend_1]=1;
		}
		
		//단계 계산
		for(int k=1; k<=n; k++) { 
			for(int i=1; i<=n; i++) { 
				for(int j=1; j<=n; j++) { 
					if(arr[i][j] > arr[i][k]+arr[k][j]) {
						arr[i][j]=arr[i][k]+arr[k][j];
					}
				}
			}
		}
		
		//케빈 베이컨 수 가장 작은 사람 구하기
		int res=INF;
		int idx=-1; //번호
		
		for(int i=1; i<=n; i++) {
			
			int total=0;
			
			for(int j=1; j<=n; j++) {
				total+=arr[i][j];
			}
			
			if(res > total) {
				res=total;
				idx=i;
			}
		}
		
		System.out.println(idx);
	}

}
