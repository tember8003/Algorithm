import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int blue=0;
	static int white=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		findNum(0,0,n);
		System.out.println(white);
		System.out.println(blue);
		
	}
	
	static void findNum(int row,int cow,int size) {
		if(check(row,cow,size)) {
			if(map[row][cow]==1) {
				blue++;
			}
			else {
				white++;
			}
			return;
		}
		int newSize=size/2;
		
		findNum(row,cow,newSize);
		findNum(row+newSize,cow,newSize);
		findNum(row,cow+newSize,newSize);
		findNum(row+newSize,cow+newSize,newSize);
	}
	
	static boolean check(int row,int cow,int size) {
		int color=map[row][cow];
		for(int i=row; i<row+size; i++) {
			for(int j=cow; j<cow+size; j++) {
				if(color!=map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
