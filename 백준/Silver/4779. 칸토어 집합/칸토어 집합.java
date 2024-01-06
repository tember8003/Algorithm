import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n;
		String str;
		while((str=br.readLine())!=null) {
			n=Integer.parseInt(str);
			repeat(n);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void repeat(int n) {
		int length = (int)Math.pow(3, n-1);
		if(n==0) {
			sb.append("-");
			return;
		}
		repeat(n-1);
		for(int i=0; i<length; i++) {
			sb.append(" ");
		}
		repeat(n-1);
	}
}
