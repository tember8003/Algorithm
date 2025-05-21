import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;

	static class Edge {
		int start;
		int end;
		int cost;

		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}

	static int V, E;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken()); // 정점 개수
		E = Integer.parseInt(st.nextToken()); // 간선 개수
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.add(new Edge(start, end, cost));
		}

		// 크루스칼 알고리즘
		int total = 0;
		while (!pq.isEmpty()) {
			Edge e = pq.poll(); // 가중치 가장 작은거 뽑기
			if (find(e.start) != find(e.end)) { // 부모가 같지 않으면(같은 집합에 속해있지 않음)
				total += e.cost;
				union(e.start, e.end); // 연결
			}
		}

		System.out.println(total);
	}

	public static int find(int v) {
		if (parent[v] == v)
			return v;
		return parent[v] = find(parent[v]);
	}

	public static void union(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);
		if (v1 < v2) {
			parent[v2] = v1;
		} else {
			parent[v1] = v2;
		}
	}
}