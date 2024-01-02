//그리디문제
//어떻게 해결해야 할지 알면 쉬운 문제
//제목:A와 B
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer s=new StringBuffer(br.readLine());
		StringBuffer t=new StringBuffer(br.readLine());
		boolean check=false;
		while(s.length()<t.length()) {
			if(t.charAt(t.length()-1)=='A') {
				t.deleteCharAt(t.length()-1);
			}
			else if(t.charAt(t.length()-1)=='B') {
				t.deleteCharAt(t.length()-1);
				t.reverse();

			}
		}
		if(t.toString().equals(s.toString())) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}
}

