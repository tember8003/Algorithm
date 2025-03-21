import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] music = new int[8];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<8; i++) {
			music[i]=Integer.parseInt(st.nextToken());
		}
		
		if(ASC(music)) {
			System.out.println("ascending");
		}
		else if(DES(music)) {
			System.out.println("descending");
		}
		else {
			System.out.println("mixed");
		}
		
	}
	
	public static boolean ASC(int[] music) {
		for(int i=1; i<8; i++) {
			if(music[i]-1 != music[i-1]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean DES(int[] music) {
		for(int i=1; i<8; i++) {
			if(music[i]+1 != music[i-1]) {
				return false;
			}
		}
		return true;
	}

}
