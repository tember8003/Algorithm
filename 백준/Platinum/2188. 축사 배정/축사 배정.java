import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int[] destination;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		visited = new boolean[M+1];
		destination = new int[M+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			Arrays.fill(visited, false);
			if(dfs(i)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static boolean dfs(int num) {
		for(int next: list[num]) {
			if(!visited[next]) {
				visited[next]=true;
				if(destination[next]==0 || dfs(destination[next])) {
					destination[next] = num;
					return true;
				}
			}
		}
		return false;
	}

}