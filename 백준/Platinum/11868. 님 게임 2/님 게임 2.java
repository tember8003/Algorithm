import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cal = Integer.parseInt(st.nextToken());
		for(int i=1; i<N; i++) {
			cal ^= Integer.parseInt(st.nextToken());
		}
		
		if(cal==0) {
			System.out.println("cubelover");
		}
		else {
			System.out.println("koosaga");
		}
	}

}
