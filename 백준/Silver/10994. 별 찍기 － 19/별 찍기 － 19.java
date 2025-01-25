import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	//별찍기 - 19
	static char[][] star;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int size = 4*N - 3;
		
		star = new char[size][size];
		for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                star[i][j] = ' ';
            }
        }
		
		if(N==1) {
			System.out.println("*");
			return;
		}
		else {
			drawStar(N,0); //재귀 실행
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					sb.append(star[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
		}
	}


	public static void drawStar(int n, int idx) {
		if(n<=0) { //종료 시점
			return;
		}
		int size = 4*n-3;
		for(int i=idx; i<idx+size; i++) {
			star[idx][i] = '*';
			star[idx+size-1][i] = '*';
			
			star[i][idx] = '*';
			star[i][idx+size-1] = '*';
		}
		
		drawStar(n-1,idx+2); //재귀
	}
}
