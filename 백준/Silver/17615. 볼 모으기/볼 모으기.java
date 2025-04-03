import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String red_blue = br.readLine();
		int count = Integer.MAX_VALUE;
		
		int temp_count=0;
		boolean check=false;
		for(int i=0; i<N; i++) {
			if(check && red_blue.charAt(i)=='R') {
				temp_count++;
				continue;
			}
			
			if(red_blue.charAt(i)=='B') {
				check=true;
			}
		}
		count = Math.min(count, temp_count);
		
		temp_count=0;
		check=false;
		for(int i=0; i<N; i++) {
			if(check && red_blue.charAt(i)=='B') {
				temp_count++;
				continue;
			}
			
			if(red_blue.charAt(i)=='R') {
				check=true;
			}
		}
		count = Math.min(count, temp_count);
		
		temp_count=0;
		check=false;
		for(int i=N-1; i>=0; i--) {
			if(check && red_blue.charAt(i)=='B') {
				temp_count++;
				continue;
			}
			
			if(red_blue.charAt(i)=='R') {
				check=true;
			}
		}
		count = Math.min(count, temp_count);
		
		temp_count=0;
		check=false;
		for(int i=N-1; i>=0; i--) {
			if(check && red_blue.charAt(i)=='R') {
				temp_count++;
				continue;
			}
			
			if(red_blue.charAt(i)=='B') {
				check=true;
			}
		}
		count = Math.min(count, temp_count);
		
		System.out.println(count);
	}
}
