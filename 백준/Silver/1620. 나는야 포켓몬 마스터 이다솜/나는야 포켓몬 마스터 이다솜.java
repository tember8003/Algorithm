import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		HashMap<Integer, String> map1 = new HashMap<Integer, String>();
		HashMap<String, Integer> map2 = new HashMap<String, Integer>();
		for(int i=0; i<n; i++) {
			String s =br.readLine();
			map1.put(i+1, s);
			map2.put(s, i+1);
		}
		for(int i=0; i<m; i++) {
			String s =br.readLine();
			if(check_num(s)) {
				System.out.println(map1.get(Integer.parseInt(s)));
			}
			else {
				System.out.println(map2.get(s));
			}
		}
	}
	static boolean check_num(String str) {
		//matches("[0-9]")는 0~9사이에 있는 숫자인지 확인하는 방법.
		return str!=null && str.matches("[0-9]+");
	}

}
