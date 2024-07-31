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
	static int modifyN; //중복 제거한 배열 길이
	static ArrayList<Integer> list;
	static Set<Integer> set = new HashSet<Integer>(); //set으로 중복 걸러내기
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) { //set에 입력하기
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		modifyN=set.size(); //수정된 길이
		
		list = new ArrayList<>(set); // set을 ArrayList로 변경
		Collections.sort(list, (o1,o2) -> o1 - o2); // 오름차순 정렬
		
		repeat("",0,0); //재귀 사용
		
	}
	public static void repeat(String str, int length,int idx) { //문자열, 길이, 반복문 시작 인덱스
		if(length==m) { //만족하는 길이가 됐다면 출력하기
			System.out.println(str);
			return;
		}
		
		for(int i=idx; i<modifyN; i++) {
			repeat(str+Integer.toString(list.get(i))+" ",length+1,i);
		}
	}
}
