import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static char[][] star;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		star = new char[N][2*N-1];
		for(int i=0; i<N; i++) {
			Arrays.fill(star[i], ' ');
		}
		
		make_star(0,N-1,N);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<2*N-1; j++) {
				sb.append(star[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void make_star(int start, int end, int N) {
		if(N==3) {
			star[start][end]='*';
			
			star[start+1][end-1]='*';
			star[start+1][end+1]='*';
			
			star[start+2][end-2]='*';
			star[start+2][end-1]='*';
			star[start+2][end]='*';
			star[start+2][end+1]='*';
			star[start+2][end+2]='*';
			return;
		}
		else {
			int cnt = N/2;
			make_star(start,end,cnt);
			make_star(start+cnt,end-cnt,cnt);
			make_star(start+cnt,end+cnt,cnt);
		}
	}
}
