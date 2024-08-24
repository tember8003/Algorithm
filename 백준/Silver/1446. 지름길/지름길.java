import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Edges {
	int start;
	int end;
	int weight;
	
	public Edges(int start,int end,int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}
public class Main {
	//DP 문제
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		Edges[] edges = new Edges[N];
		int[] dp = new int[D+1];
		
		for(int i=0; i<=D; i++) {
			dp[i]=i;
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edges(start, end, weight);
		}
		
		for(int i=1; i<=D; i++) {
			dp[i] = Math.min(dp[i], dp[i-1]+1);
			for(int j=0; j<N; j++) {
				if(edges[j].end == i) {
					dp[i] = Math.min(dp[i], dp[edges[j].start]+edges[j].weight);
				}
			}
		}
		
		System.out.println(dp[D]);
	}
}
