import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	//DFS 알고리즘 사용
	
	static int N,M; //맵 크기
	static int[][] map; //맵
	static boolean[][] visited; //방문 여부 확인
	static int[] dx = {0,0,-1,1};//동서남북
	static int[] dy = {-1,1,0,0};
	static ArrayList<Node> node = new ArrayList<>(); //치즈 리스트
	static int nodeCnt=0; //치즈 개수
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		//입력받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1]; 
		
		
		for(int i=1; i<=N; i++) { //맵 입력
			st=new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) { //해당 맵이 치즈일 경우
					node.add(new Node(i,j));
					nodeCnt++;
				}
			}
		}
		int hour=0; //시간
		
		while(node.size()>0) { //치즈가 다 없어질 때까지
			hour++;
			visited=new boolean[N+1][M+1];
			dfs(1,1); //내부 공기 외부 공기 나누기 작업
			melt(); //치즈 녹이기
		}
		
		System.out.println(hour);
		
	}
	public static void dfs(int x,int y) { 
		//내부 공기 외부 공기 나누기 작업
		visited[x][y]=true;
		map[x][y]=2; //외부 공기를 2로
		
		for(int i=0; i<4; i++) {
			int nx = x+ dx[i];
			int ny = y+ dy[i];
			
			if(nx<=0 || ny<=0 || nx>N || ny>M) {
				continue;
			}
			if(visited[nx][ny] || map[nx][ny]==1) {
				continue;
			}
			dfs(nx,ny);
		}
	}
	
	public static void melt() {//치즈 녹이기
		for(int i=0; i<node.size(); i++) {
			int x= node.get(i).x;
			int y= node.get(i).y;
			int cnt=0;
			
			for(int j=0; j<4; j++) {
				int nx= x+dx[j];
				int ny= y+dy[j];
				
				if(nx <=0 || ny <= 0 || nx>N || ny>M) {
					continue;
				}
				if(map[nx][ny]==2) {
					//동서남북으로 외부공기를 만나면 카운트 + 1
					cnt++;
				}
			}
			if(cnt>=2) { //외부공기와 2번 이상 맞닿을 경우
				map[x][y]=0; //치즈 녹음
				nodeCnt--;
				node.remove(i);
				i--;
			}
		}
	}
}
	class Node{//배열리스트를 위한 Node 클래스
		int x,y;
		Node(int x ,int y){
			this.x=x;
			this.y=y;
		}
	}


