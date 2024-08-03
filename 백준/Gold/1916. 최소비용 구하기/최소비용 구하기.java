import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int end;
	int weight;
	public Node(int end,int weight) {
		this.end = end;
		this.weight = weight;
	}
	
	public int compareTo(Node n) {
		return weight - n.weight;
	}
}
public class Main {
	//다익스트라 알고리즘 사용
	static int n,m;
	static int bus_start,bus_end;
	static ArrayList<ArrayList<Node>> list;
	static int[] dist;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		list = new ArrayList<ArrayList<Node>>();
		dist = new int[n+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<Node>());
		}
		
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int pay = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Node(end,pay));
		}
		
		st = new StringTokenizer(br.readLine());
		bus_start = Integer.parseInt(st.nextToken());
		bus_end = Integer.parseInt(st.nextToken());
		
		findRoad(); //최단거리 찾기
		System.out.println(dist[bus_end]);
	}
	public static void findRoad() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		boolean[] check = new boolean[n+1];
		pq.add(new Node(bus_start,0));
		dist[bus_start]=0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.end;
			
			if(check[cur]) {
				continue;
			}
			check[cur]=true;
			
			for(Node node:list.get(cur)) {
				if((!check[node.end]) && dist[node.end] > dist[cur]+node.weight) {
					dist[node.end] = dist[cur]+node.weight;
					pq.add(new Node(node.end,dist[node.end]));
				}
			}
		}
	}
}
