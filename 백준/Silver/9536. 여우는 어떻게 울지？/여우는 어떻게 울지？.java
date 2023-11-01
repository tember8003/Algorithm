import java.io.BufferedReader;
import java.util.*;
import java.io.IOException; 
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		//https://javaju.tistory.com/58 참고
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		ArrayList<String> list= new ArrayList<>();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				list.add(st.nextToken());
			}
			while(true) {
				st=new StringTokenizer(br.readLine());
				st.nextToken(); st.nextToken();
				String mic = st.nextToken();
				if(mic.equals("the")) {
					st.nextToken(); st.nextToken();
					break;
				}
				for(int j=0; j<list.size(); j++) {
					if(list.get(j).equals(mic)) {
						list.remove(j); j--;
					}
				}
			}
			for(int j=0; j<list.size(); j++) {
				sb.append(list.get(j)+" ");
			}
			System.out.println(sb.toString());
			list.clear();
			sb.setLength(0);
		}
	}
}
