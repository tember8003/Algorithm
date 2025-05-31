import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] check = new boolean[N][N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken())-1;
			int two = Integer.parseInt(st.nextToken())-1;
			check[one][two]=true;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(check[j][i] && check[i][k]) {
						check[j][k]=true;
					}
				}
			}
		}
		
		int[] count = new int[N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(check[i][j] || check[j][i]) {
					count[i]++;
				}
			}
		}
		
		int result=0;
		for(int i=0; i<N; i++) {
			if(count[i]==N-1) {
				result++;
			}
		}
		
		
		System.out.println(result);
	}
}