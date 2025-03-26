import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,B;
	static int[][] map;
	static int MAX_VAL = -1;
	static int MIN_VAL = 257;
	static int time = Integer.MAX_VALUE;
	static int mine = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				MAX_VAL = Math.max(map[i][j],MAX_VAL);
				MIN_VAL = Math.min(map[i][j], MIN_VAL);
			}
		}
		
		if(MAX_VAL==MIN_VAL) {
			System.out.println(0+" "+ MAX_VAL);
		}
		else {
			for(int i= MIN_VAL; i<=MAX_VAL; i++) {
				dig(i,0);
			}
			
			System.out.println(time+" "+mine);
		}
	}
	public static void dig(int ground, int timeCount) {	
		int invenCount = B;
		boolean check = true;
		
		for(int j=0; j<N; j++) {
			for(int k = 0; k<M; k++) {
				if(map[j][k] > ground) {
					timeCount += (map[j][k] - ground)*2;
					invenCount += (map[j][k] - ground);
				}
				if(map[j][k] <ground) {
					timeCount += (ground - map[j][k]);
					invenCount -= (ground - map[j][k]);
				}
				
			}
		}
		
		if(invenCount < 0) {
			return;
		}
		else {
			if(timeCount==0) {
				return;
			}
			if(time > timeCount || (time == timeCount && mine < ground)) {
				time = timeCount;
				mine=ground;
			}
		}
	}
}
