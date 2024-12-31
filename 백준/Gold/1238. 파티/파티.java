import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node { //다익스트라 알고리즘
	int idx;
	int cost;

	// 생성자
	Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
}

public class Main {
	//다익스트라 알고리즘 사용
	//https://sskl660.tistory.com/59 참고
	static int N,M,X;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>(); //집->X 
	static ArrayList<ArrayList<Node>> reverse_graph = new ArrayList<ArrayList<Node>>(); //X->집
	
	static int[] road; //집에서 X로
	static int[] road2; //X에서 집으로
	static boolean[] visited; //방문여부 체크
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Node>());
			reverse_graph.add(new ArrayList<Node>());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(new Node(end,cost));
			reverse_graph.get(end).add(new Node(start,cost));
		}

		
		road=dijkstra(graph);//집에서 X로 가는 다익스트라 계산
		road2=dijkstra(reverse_graph);//X에서 집으로 가는 다익스트라 계산
		
		int result = 0;
		for(int i=1; i<N+1; i++) {
			if(road[i]==Integer.MAX_VALUE || road2[i]==Integer.MAX_VALUE) {//만약 둘 중 하나라도 MAX_VALUE면 방문 X
				continue;
			}
			else {
				result = Math.max(result, road[i]+road2[i]);
			}
		}
		System.out.println(result);//최장거리 계산
		
	}
	public static int[] dijkstra(ArrayList<ArrayList<Node>> graph) {
		int[] road = new int[N+1];
		for(int i=0; i<N+1; i++) { //거리 초기화
			road[i]=Integer.MAX_VALUE;
		}
		
		road[X] = 0;//시작점 설정
		visited= new boolean[N+1];//방문여부 초기화
		
		for(int i=0; i<N; i++) {//다익스트라 알고리즘 사용
			int nodeValue = Integer.MAX_VALUE;
			int nodeIdx = 0;
			
			for(int j=1; j<N+1; j++) {
				if(!visited[j] && road[j] < nodeValue) {
					nodeValue = road[j];
					nodeIdx = j;
				}
			}
			
			visited[nodeIdx] = true;
			
			for(int j = 0; j<graph.get(nodeIdx).size(); j++) {
				Node node = graph.get(nodeIdx).get(j);
				
				if(road[node.idx] > road[nodeIdx] + node.cost) {
					road[node.idx] = road[nodeIdx] + node.cost;
				}
			}
		}
		return road;
	}
}
