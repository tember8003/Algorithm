import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		char[] arr = str.toCharArray();
		
		int count_zero = 0;
		int count_one = 0;
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='0') {
				count_zero++;
			}
			else {
				count_one++;
			}
		}
		
		count_zero /=2;
		count_one /=2;
		
		for(int i=0; i<str.length(); i++) {
			if(count_one == 0 ) {
				break;
			}
			if(str.charAt(i)=='1') {
				arr[i]='9';
				count_one--;
			}
		}
		
		for(int i=str.length()-1; i>=0; i--) {
			if(count_zero==0) {
				break;
			}
			if(str.charAt(i)=='0') {
				arr[i]='9';
				count_zero--;
			}
		}
		
		for(int i=0; i<str.length(); i++) {
			if(arr[i]=='9') {
				continue;
			}
			sb.append(arr[i]);
		}
		
		System.out.println(sb.toString());
	}
}
