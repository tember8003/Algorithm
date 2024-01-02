//제목:회사에 있는 사람
//해시맵
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/* 처음 시도했던 코드 (시간초과 나옴)
public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
	br= new BufferedReader(new InputStreamReader(System.in));
	int n=Integer.parseInt(br.readLine());
	boolean leave[]=new boolean[n];
	String[] name=new String[n];
	String[] en=new String[n];
	String[] result=new String[n];
	for(int i=0; i<n;i++) {
		st = new StringTokenizer(br.readLine());
		name[i]=st.nextToken();
		en[i]=st.nextToken();
	}
	sb=new StringBuilder();
	for(int i=0; i<n; i++) {
		for(int j=i+1; j<n; j++) {
			if(name[i].equals(name[j])) {
				if(en[i].equals("enter") && en[j].equals("leave")) {
					leave[i]=leave[j]=true;
				}		
			}
		}
	}
	for(int i=0; i<n; i++) {
		if(!leave[i]) {
			sb.append(name[i]).append("\n");
		}
	}
	System.out.println(sb);
	}
	
}
*/
public class Main { //https://studydeveloper.tistory.com/4 코드 참고 (Hashmap을 몰랐음.)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		HashMap<String, String> map = new HashMap<String, String>();

		for (int i = 0; i < n; i++) {
			String name = sc.next();
			String state = sc.next();

			if (map.containsKey(name)) {
				map.remove(name);
			} else {
				map.put(name, state);
			}
		}

		ArrayList<String> list = new ArrayList<String>(map.keySet());
		Collections.sort(list, Collections.reverseOrder());
		
		for(var li : list) {
			System.out.print(li + " ");
		}
	}
}
