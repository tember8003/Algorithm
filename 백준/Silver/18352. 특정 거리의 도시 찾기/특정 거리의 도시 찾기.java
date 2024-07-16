import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> ans = new ArrayList<>(); //정답 저장용
	static StringBuilder sb = new StringBuilder();//출력용
	static int[] distance; //거리 확인용
	static ArrayList<Integer>[] edges; //도시 연결 입력용
	static int n,m,k,x; //도시 개수 , 도로 개수 , 거리 정보 , 출발 도시 번호
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		edges = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			edges[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			edges[one].add(two); //단방향이므로 한쪽으로만 연결해준다.
		}
		
		distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		BFS();
		
		if(ans.size()==0) { //최단거리가 K인 도시가 존재하지 않는다면?
			System.out.println(-1);
		}
		else {
			Collections.sort(ans);
			for(int cur : ans) {
				sb.append(cur+"\n");
			}
			System.out.println(sb.toString());
		}
	}
	public static void BFS() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(x);
		distance[x] = 0;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(distance[cur] > k) { //최단 거리가 k 이상이면 고려할 필요 없음.
				break;
			}
			if(distance[cur]==k) {
				ans.add(cur);
			}
			
			for(int next : edges[cur]) { 
				if(distance[next] == Integer.MAX_VALUE) {
					distance[next] = distance[cur]+1;
					queue.add(next);
				}
			}
		}
	}
}
