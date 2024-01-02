//브루트포스 문제
//제목:문자열
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scan =new Scanner(System.in);
		String a=scan.next();
		String b=scan.next();
		int min=1000;
		for(int i=0; i<b.length()-a.length()+1; i++) {
			int count=0;
			for(int j=i; j<i+a.length(); j++) {
				if(a.charAt(j-i)!=b.charAt(j)) {
					count++;
				}
			}
			if(count<min) {
				min=count;
			}
		}
		System.out.println(min);
	}
}
