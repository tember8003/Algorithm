import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int start = 8; //daldidalgo 만들 때
		for(int i=1;i<=1000000001; i++) {
			if(n-Math.pow(2, i)==0) {
				start+=i+2;
				break;
			}
			else if(n-Math.pow(2, i)<0){
				start += i+1;
				break;
			}
		}
		System.out.println(start);
	}
}
