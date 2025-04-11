import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<N+M; i++) {
			String str = br.readLine();
			
			if(map.containsKey(str)) {
				map.put(str, map.get(str)+1);
			}
			else {
				map.put(str, 1);
			}
		}
		
		Vector<String> vec = new Vector<>();
		for(String key : map.keySet()) {
			if(map.get(key)==2){
				vec.add(key);
			}
		}
		
		Collections.sort(vec);
		System.out.println(vec.size());
		vec.forEach((str)->{
			System.out.println(str);
		});
		
	}

}
