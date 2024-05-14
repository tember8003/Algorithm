import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int M,N;
		int x,y;
		boolean check= false;
		
		int num = Integer.parseInt(br.readLine());
		
		for (int j=0; j<num; j++) {
			st= new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			
			for (int i=x; i<(M*N); i+=M) {
				if(i % N ==y) {
					System.out.println(i+1);
					check= true;
					break;
				}
			}
			if(!check) {
				System.out.println(-1);
			}
			check=false;	
		}
	}
}
