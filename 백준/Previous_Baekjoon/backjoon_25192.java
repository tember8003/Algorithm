//해시 맵 이용
//제목:인사성 밝은 곰곰이
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,Integer> maps = new HashMap<>();
		int n=Integer.parseInt(br.readLine());
		int count=0;
		for(int i=0; i<n; i++) {
			String str=br.readLine();
			if(str.equals("ENTER")) {
				maps.clear();
			}
			else {
				if(!maps.containsKey(str)) {
					maps.put(str, 1);
					count++;
				}
				else {
					continue;
				}
			}
		}
		System.out.println(count);
	}
}
