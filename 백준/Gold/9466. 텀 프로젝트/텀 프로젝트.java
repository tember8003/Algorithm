import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static boolean[] check;
	static int[] arr;
	static int count=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(T-->0) {
			count=0;
			int n = Integer.parseInt(br.readLine());
			
			arr = new int[n+1];
			visited =  new boolean[n+1];
			check = new boolean[n+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1; i<=n; i++) {
				if(!check[i]) {
					dfs(i);
				}
			}
			
			sb.append(n-count+"\n");
		}
		System.out.println(sb.toString());
		
	}
	public static void dfs(int n) {
		if(visited[n]) {
			check[n]=true;
			count++;
		}
		else {
			visited[n]=true;
		}
		
		if(!check[arr[n]]) {
			dfs(arr[n]);
		}
		
		visited[n] = false;
		check[n] = true;
	}

}
