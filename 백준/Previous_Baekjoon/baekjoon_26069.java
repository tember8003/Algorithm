//해시셋 사용
//제목:붙임성 좋은 총총이


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> sets=new HashSet<>();
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st;
		sets.add("ChongChong");
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			String a=st.nextToken();
			String b=st.nextToken();
			if(sets.contains(a)||sets.contains(b)) {
				sets.add(a);
				sets.add(b);
			}
			
		}
		System.out.println(sets.size());
	}
}
