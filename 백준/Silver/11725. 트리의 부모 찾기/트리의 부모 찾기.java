import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	//bfs 문제
	static boolean[] visited; //방문 여부 확인용
	static int[] parent; //노드 부모 배열
	static ArrayList<Integer>[] tree; //입력 받을 정점 배열
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			tree[i] = new ArrayList<>();
		}
		visited = new boolean[N+1]; 
		parent = new int[N+1];
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			
			tree[one].add(two); //각각의 정점을 연결한다.
			tree[two].add(one);
		}
		bfs();
	}
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		visited[1]=true;
		while(!queue.isEmpty()) {
			int v = queue.remove();
			for(int node : tree[v]) {
				if(visited[node]) {
					continue;
				}
				visited[node]=true;
				queue.add(node);
				parent[node]= v;
			}
		}
		for(int i=2; i<=N; i++) {
			System.out.println(parent[i]);
		}
	}
}
