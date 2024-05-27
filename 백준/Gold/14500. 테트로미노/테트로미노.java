import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//DFS로 푼 문제
	
	static int N,M;
	static int map[][]; //배열
	static boolean visited[][]; //방문 여부 확인용
	static int maxValue=Integer.MIN_VALUE; //계산할 최댓값
	static int[] dx = {0,0,-1,1}; //동서남북 이동
	static int[] dy = {-1,1,0,0}; //동서남북 이동
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //입력받기
		M = Integer.parseInt(st.nextToken());
		map= new int[N+1][M+1]; //크기 설정
		visited = new boolean[N+1][M+1];
		
		for(int i=1; i<=N; i++) { //배열 입력
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=N; i++) { //dfs 실행
			for(int j=1; j<=M; j++) {
				if(!visited[i][j]) {
					visited[i][j]= true; //초기 위치 방문
					dfs(j,i,1,map[i][j]); 
					visited[i][j]= false;
				}
			}
		}
		
		System.out.println(maxValue);
		
	}
	public static void dfs(int row,int col,int count,int sum) {
		
		if(count==4) {//블럭이 4개가 채워지면 종료
			maxValue = Math.max(maxValue, sum);
		}
		else {
			for(int i=0; i<4; i++) {
				int newRow = row + dx[i]; //새로운 이동 위치
				int newCol = col + dy[i]; 
				
				if(newCol <=0 || newRow <=0 || newCol > N || newRow > M) { //범위 벗어나면 X
					continue;
				}
				if(!visited[newCol][newRow]) { 
					if(count==2) { //(ㅗ)자 모양 만들기 위한 용도
						visited[newCol][newRow] = true;
						dfs(row,col,count+1,sum+map[newCol][newRow]);
						visited[newCol][newRow] = false;
					}
					
					visited[newCol][newRow] = true;
					dfs(newRow,newCol,count+1,sum+map[newCol][newRow]);
					visited[newCol][newRow] = false;
				}
			}
		}
	}
}
