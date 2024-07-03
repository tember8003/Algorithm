import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//백트래킹 문제
	static int[][] map= new int[9][9];//9x9 스도쿠 배열
	static StringBuilder sb = new StringBuilder(); //출력용
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0; i<9; i++) { //입력받기
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		sudoku(0,0); //백트래킹 실행
	}
	public static void sudoku(int row,int col) {
		if(col==9) { //열이 채워지면 다음 행으로
			sudoku(row+1,0);
			return;
		}
		
		if(row==9) { //행까지 채워지면 출력하기
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(map[i][j]+" ");
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			System.exit(0); //하나의 답만 취급하므로 출력 후 종료하기.
		} 
		
		if(map[row][col]==0) { //채워야 할 부분일 경우
			for(int i=1; i<=9; i++) {
				//가로 세로 3x3 박스 모두 가능한 숫자라면
				if(check_row(row,i)==true && check_col(col,i)==true && check_box(row,col,i)==true) {
					map[row][col]=i;
					sudoku(row,col+1);
				}
			}
			map[row][col]=0;
			return;
		}
		sudoku(row,col+1);
	}
	
	public static boolean check_row(int row,int val) { //가로 열 조사
		for(int i=0; i<9; i++) {
			if(map[row][i]==val) {//해당 열에 같은 수가 있으면 안된다.
				return false;
			}
		}
		return true;
	}
	
	public static boolean check_col(int col,int val) { //세로 행 조사
		for(int i=0; i<9; i++) {
			if(map[i][col]==val) { //해당 행에 같은 수가 있으면 안된다.
				return false;
			}
		}
		return true;
	}
	
	public static boolean check_box(int row,int col,int val) { //해당 부분 3x3 박스 조사
		int start_x = (row/3)*3; //시작 박스 조정
		int start_y = (col/3)*3;
		for(int i=start_x; i<start_x+3; i++) {
			for(int j=start_y; j<start_y+3; j++) {
				if(map[i][j]==val) { //3x3 박스내 같은 수가 있으면 안된다.
					return false;
				}
			}
		}
		return true;
	}
}
