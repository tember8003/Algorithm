import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	static int one=0;
	static int zero=0;
	static int minus_one=0;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		StringTokenizer st;
		map=new int[n][n];
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		FindPaper(0,0,n);
		System.out.println(minus_one);
		System.out.println(zero);
		System.out.println(one);
	}
	static void FindPaper(int row,int col,int size) {
		if(check(row,col,size)) {
			if(map[row][col]==1) {
				one++;
			}
			else if(map[row][col]==0) {
				zero++;
			}
			else {
				minus_one++;
			}
			return;
		}
		
		int newSize=size/3;
		
		FindPaper(row, col, newSize); //첫번째 라인
		FindPaper(row, col+newSize, newSize);
		FindPaper(row, col+newSize*2, newSize);
		
		FindPaper(row+newSize, col, newSize); //두번째 라인
		FindPaper(row+newSize, col+newSize, newSize);
		FindPaper(row+newSize, col+newSize*2, newSize);

		FindPaper(row+newSize*2, col, newSize); //세번째 라인
		FindPaper(row+newSize*2, col+newSize, newSize);
		FindPaper(row+newSize*2, col+newSize*2, newSize);
	}
	static boolean check(int row,int col,int size) {
		int color=map[row][col];
		for(int i=row; i<row+size; i++) {
			for(int j=col; j<col+size; j++) {
				if(color !=map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
