import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	//BFS 알고리즘 사용
	static int[] d8i = {2,1,-1,-2,-2,-1,1,2}; //나이트가 움직일 수 있는 경로
	static int[] d8j = {1,2,2,1,-1,-2,-2,-1};
	
	static int[][] chessMap; //체스판 2차원 배열
	static int I; //체스판 크기
	static boolean[][] visited;//방문 여부 확인
	
	static int start_i; static int start_j; //시작 위치
	static int end_i; static int end_j; //도착 위치
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder(); //입력 , 출력 용도
		
		int n =  Integer.parseInt(br.readLine()); //테스트케이스 입력받기
		
		for(int i=0; i<n; i++) {
			I = Integer.parseInt(br.readLine());
			chessMap = new int[I][I];
			visited=  new boolean[I][I];
			
			st = new StringTokenizer(br.readLine());
			start_i = Integer.parseInt(st.nextToken());
			start_j = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			end_i = Integer.parseInt(st.nextToken());
			end_j = Integer.parseInt(st.nextToken());
			
			
			BFS(); //BFS 실행
			
			sb.append(chessMap[end_i][end_j]+"\n"); //해당 결과 저장
		}
		
		System.out.println(sb.toString()); //결과 출력
	}
	
	public static void BFS() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {start_i,start_j});
		visited[start_i][start_j]=true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int nx = now[0];
			int ny = now[1];
			
			for(int i=0; i<8; i++) {
				int tx = nx + d8i[i];
				int ty = ny + d8j[i];
				
				if(tx < 0 || ty < 0 || tx>=I || ty >= I) { //범위 벗어날 경우 X
					continue;
				}
				if(visited[tx][ty]) { //이미 방문했을 경우 X
					continue;
				}
				queue.add(new int[] {tx,ty});
				chessMap[tx][ty] = chessMap[nx][ny]+1;
				visited[tx][ty]=true;		
			}
		}
	}
}
