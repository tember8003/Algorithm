import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
	int index;
	int cost;
	
	public Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class Main {
	//DFS 문제
	static ArrayList<Node>[] list; //간선과 가중치를 가짐
	static boolean[] visited;
	static int result=0; //결과 (최댓값)
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			//양방향이므로 둘 다 ADD해준다.
			list[one].add(new Node(two,cost));
			list[two].add(new Node(one,cost));
		}
		
		for(int i=1; i<=n; i++) {
			visited = new boolean[n+1];
			dfs(i,0);
		}
		
		System.out.println(result);
	}
	public static void dfs(int node, int cost) { //DFS 실행
		if(result < cost) {
			result = cost;
		}
		visited[node]=true;
		
		for(int i=0; i<list[node].size(); i++) {
			Node n = list[node].get(i);
			if(!visited[n.index]) {
				dfs(n.index,cost+n.cost);
				visited[n.index]=true;
			}
		}
	}
}
