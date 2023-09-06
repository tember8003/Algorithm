import java.io.BufferedReader;
import java.util.*;
import java.io.IOException; 
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   
		String str=br.readLine();
		HashMap<String, String> maps = new HashMap<>();
		StringTokenizer st = new StringTokenizer(str);
		int n=Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++) {
			String cnt=br.readLine();
			StringTokenizer st2=new StringTokenizer(cnt);
			String site=st2.nextToken();
			String name=st2.nextToken();
			maps.put(site, name);
		}
		for(int i=0; i<m; i++) {
			String temp=br.readLine();
			if(maps.containsKey(temp)) {
				bw.write(maps.get(temp)+"\n");
			}
		}
		bw.flush();
	}
}
