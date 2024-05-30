import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    //백트래킹
	static int N,M;
	static Set<String> set = new HashSet<>(); //중복 제거용
	static int[] array; //배열
	static int[] temp; //임시 배열
	static boolean[] visited; //방문 여부 확인
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//입력 받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[N];
		temp = new int[M];
		visited = new boolean[N];
		
		//배열 입력 받기
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array); //오름차순 정렬
		
		repeat(0,0);//백트래킹 실행
		System.out.println(sb.toString());
	}
	public static void repeat(int num, int cnt) {
		if(cnt==M) { //만약 원하는 길이라면?
			StringBuilder temp_str = new StringBuilder();
			for(int i=0; i<M; i++) {
				temp_str.append(temp[i]).append(" ");
			}
			String str = temp_str.toString();
			if(!set.contains(str)) {//SET에 들어있지 않아야 함. (중복 제거)
				set.add(str);
				sb.append(str).append("\n");
			}
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]) {//한번 들어갔던 배열 요소 참조 제거용
				visited[i]=true;
				temp[cnt]=array[i];
				repeat(i,cnt+1);
				visited[i]=false;
			}
		}
	}
}
