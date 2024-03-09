import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N; //배열 크기
	static int[][] map; //맵
	static boolean[][] visited; //방문 여부 확인 
	static int max_rain=Integer.MIN_VALUE; //비에 잠기는 최대 높이 설정
	static int result=0; //dfs 결과값
	static int count = Integer.MIN_VALUE; //최대 안전 영역
	static int[] dx = {0,0,-1,1}; //동서남북 이동
	static int[] dy= {-1,1,0,0}; //동서남북 이동
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N]; //배열 크기 설정
		
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j] > max_rain) {
					max_rain=map[i][j]; //최대 높이 설정
				}
			}
		}
		
		for(int i=0; i<=max_rain; i++) { //0부터 최대높이까지 비에 잠기게 한다.
			//초기화
			result=0;
			visited = new boolean[N][N];
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(map[j][k]>i && !visited[j][k]) { //만약 비에 잠기지 않고 방문하지 않았다면?
						dfs(j,k,i); //dfs 실행
						result++;
					}
				}
			}
			if(result > count) { //최대 안전 높이 갱신
				count=result; 
			}
		}
		System.out.println(count);
	}
	public static void dfs(int x,int y, int tmp) {
		visited[x][y]=true;
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0 || ny<0 || nx>=N || ny>=N) { //범위 벗어날 경우
				continue;
			}
			//만약 동서남북으로 이동했을 때 잠기지 않은 구역이 더 있다면 ?
			if(map[nx][ny]> tmp && !visited[nx][ny]) { 
				visited[nx][ny]=true;
				dfs(nx,ny,tmp);
			}
		}
		return;
	}
}
