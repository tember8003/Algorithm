import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	//다익스트라 알고리즘 사용
	
	static class Node implements Comparable<Node>{
		int idx;
		int cost;
		
		Node(int idx, int cost){
			this.idx = idx;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.cost - n.cost;
		}
	}
	
	static int N,M;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	static boolean[] visited;
	static int[] dist;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		dist = new int[N+1];
		visited = new boolean[N+1];
		for(int i=0; i<N+1; i++) {
			dist[i]=Integer.MAX_VALUE;
		}
		dist[1]=0; //시작 위치 지정
		
		for(int i=0; i<M; i++) {//입력 넣어주기
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			//그래프는 양방향으로 설정한다.
			graph.get(start).add(new Node(end, cost));
			graph.get(end).add(new Node(start, cost));
		}
		
		dijkstra();
		
		System.out.println(dist[N]);
	}
	
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(1,0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(!visited[cur.idx]) {
				visited[cur.idx] = true;
				for(int i=0; i<graph.get(cur.idx).size(); i++) {
					Node node = graph.get(cur.idx).get(i);
					if(dist[node.idx] > dist[cur.idx] + node.cost) {
						dist[node.idx] = dist[cur.idx]+node.cost;
						pq.offer(new Node(node.idx, dist[node.idx]));
					}
				}
			}
		}
	}
	
}
