import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
		int length = str.length();
		int bomb_length = bomb.length();
		Stack<Character> st = new Stack<Character>();
		for(int i=0; i<length; i++) {
			char c = str.charAt(i);
			st.add(c);
			if(st.size()>=bomb_length) {
				boolean same = true;
				for(int cnt = 0; cnt < bomb_length; cnt++) {
					char c1 = st.get(st.size() - bomb_length + cnt);
					char c2 = bomb.charAt(cnt);
					if(c1 !=c2) {
						same=false;
						break;
					}
				}
				if(same) {
					for(int idx = 0; idx<bomb_length; idx++) {
						st.pop();
					}
				}
			}
		}
		if(st.size()==0) {
			System.out.println("FRULA");
		}
		else {
			StringBuilder sb = new StringBuilder();
			for(char c: st) {
				sb.append(c);
			}
			System.out.println(sb.toString());
		}
	}
}
