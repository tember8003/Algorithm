import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] number;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<>());
		}
		number = new int[N+1];
		
		for(int i=0; i<M; i++) {
			String input = br.readLine();
			String[] parts = input.split(" ");
			int pd_num = Integer.parseInt(parts[0]);
			for(int j=1; j<=pd_num-1; j++) {
				int one = Integer.parseInt(parts[j]);
				int two = Integer.parseInt(parts[j+1]);
				
				graph.get(one).add(two);
				number[two]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(number[i]==0) {
				queue.offer(i);
			}
		}
		
		int check_count = 0;
		while(!queue.isEmpty()) {
			int queue_num = queue.poll();
			
			sb.append(queue_num+"\n");
			check_count++;
			
			for(int i=0; i<graph.get(queue_num).size(); i++) {
				int temp = graph.get(queue_num).get(i);
				
				number[temp]--;
				if(number[temp]==0) {
					queue.offer(temp);
				}
			}
		}
		
		if(check_count==N) {
			System.out.println(sb.toString());
		}
		else {
			System.out.println(0);
		}	
	}
}
