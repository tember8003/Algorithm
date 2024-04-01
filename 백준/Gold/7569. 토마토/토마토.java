import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{ //가로 세로 높이를 표현하기 위한 클래스
	int height;
	int row;
	int col;
	
	public Point(int height,int row,int col) {
		this.height=height;
		this.row=row;
		this.col=col;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
}
public class Main {
	static int N,M,H;//가로 세로 높이
	static int[] Move_x= {-1,1,0,0,0,0};//좌우이동
	static int[] Move_y= {0,0,-1,1,0,0};//상하이동
	static int[] Move_z= {0,0,0,0,-1,1};//높이 기준 상하이동
	static int[][][] arr;
	static Queue<Point> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//가로 세로 높이 입력받기
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		
		arr= new int[H+1][N+1][M+1];
		
		for(int i=1; i<=H; i++) {
			for(int j=1; j<=N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=1; k<=M; k++) {
					arr[i][j][k]=Integer.parseInt(st.nextToken());
					//배열 값 넣기
					
					if(arr[i][j][k]==1) { //만약 토마토가 익었다면?
						queue.add(new Point(i,j,k)); //Queue에 넣어줌.
					}
				}
			}
		}
		
		System.out.println(bfs());

	}
	public static int bfs() {
		while(!queue.isEmpty()) {
			Point point= queue.poll();
			
			int height= point.getHeight();
			int row = point.getRow();
			int col = point.getCol();
			
			for(int i=0; i<6; i++) {//동서남북위아래 6가지 경우
				//각각 새로운 위치 설정
				int move_height = height+Move_z[i];
				int move_row = row+Move_x[i];
				int move_col = col+Move_y[i];
				
				if(check(move_height, move_row, move_col)) {//계속 실행해도 되는지 확인
					queue.add(new Point(move_height,move_row,move_col));
					arr[move_height][move_row][move_col] = arr[height][row][col]+1;
				}
			}
		}
		int result = Integer.MIN_VALUE; //최대 구하기
		
		for(int i=1; i<=H; i++) {
			for(int j=1; j<=N; j++) {
				for(int k=1; k<=M; k++) {
					if(arr[i][j][k] == 0) {//만약 익지 않은 구역이 있다면 -1 return
						return -1;
					}
					result = Math.max(result, arr[i][j][k]); //최대 구하기
				}
			}
		}
		
		if(result==1) {//만약 최대가 1이면 모두 익어있던 상황임.
			return 0;
		}
		else {
			return result-1;
		}
	}
	
	public static boolean check(int height , int row ,int col) {
		if(height < 1 || height > H || row < 1 || row > N || col < 1 || col > M) {
			//범위를 벗어날 경우 false
			return false;
		}
		if(arr[height][row][col]==0) { //토마토가 익지 않았다면 true
			return true;
		}
		else { //익은 경우 혹은 토마토가 없는 칸이면 false
			return false;
		}
	}

}
