import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //분할정복 문제
	static int[][] map;
	static int R;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		R = Integer.parseInt(br.readLine());
		map = new int[R][R];
		
		for(int i=0; i<R; i++) {
			String temp = br.readLine();
			for(int j=0; j<R; j++) {
				map[i][j]= temp.charAt(j)-'0';
			}
		}
        
		findResult(0,0,R);
		System.out.println(sb.toString());
	}
    
	public static void findResult(int x,int y, int size) {
		if(check(x,y,size)) {
			if(map[x][y]==0) {
				sb.append("0");
			}
			else {
				sb.append("1");
			}
		}
		else {
			sb.append("(");
			int newSize = size/2;
			findResult(x,y,newSize);
			findResult(x,y+newSize,newSize);
			findResult(x+newSize,y,newSize);
			findResult(x+newSize,y+newSize,newSize);
			sb.append(")");
		}
	}
    
	public static boolean check(int x,int y, int size) {
		int num = map[x][y];
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(num!=map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
