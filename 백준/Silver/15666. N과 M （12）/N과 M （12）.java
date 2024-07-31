import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int modifyN;
	static int[] arr;
	static Set<Integer> set = new HashSet<Integer>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		modifyN=set.size();
		arr= new int[modifyN];
		ArrayList<Integer> list = new ArrayList<>(set); // set을 ArrayList로 변경
		Collections.sort(list, (o1,o2) -> o1 - o2); // 오름차순 정렬
		
		for(int i=0; i<modifyN; i++) {
			arr[i]=list.get(i);
		}
		
		repeat("",0,0);
		
	}
	public static void repeat(String str, int length,int idx) {
		if(length==m) {
			System.out.println(str);
			return;
		}
		for(int i=idx; i<modifyN; i++) {
			repeat(str+Integer.toString(arr[i])+" ",length+1,i);
		}
	}
}
