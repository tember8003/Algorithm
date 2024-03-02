import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] track = new int[101];
	static int[] dice = {1,2,3,4,5,6};
	static int[] count=new int[101];
	static boolean[] visited=new boolean[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int temp_1; int temp_2;
		for(int i=0; i<n; i++) {
			st= new StringTokenizer(br.readLine());
			temp_1=Integer.parseInt(st.nextToken());
			temp_2=Integer.parseInt(st.nextToken());
			
			track[temp_1]=temp_2;
		}
		for(int i=0; i<m; i++) {
			st= new StringTokenizer(br.readLine());
			temp_1=Integer.parseInt(st.nextToken());
			temp_2=Integer.parseInt(st.nextToken());
			
			track[temp_1]=temp_2;
		}
		bfs();
		
	}
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		count[1]=0;
		visited[1]=true;
		while(!queue.isEmpty()) {
			int cur=queue.poll();
			if(cur==100) {
				System.out.println(count[100]);
				return;
			}
			for(int i=0; i<6; i++) {
				int nx=cur+dice[i];
				if(nx>100) {
					continue;
				}
				if(visited[nx]) {
					continue;
				}
				visited[nx]=true;
				
				if(track[nx]!=0) {
					if(!visited[track[nx]]) {
						queue.offer(track[nx]);
						visited[track[nx]]=true;
						count[track[nx]] = count[cur]+1;
					}
				}
				else {
					queue.offer(nx);
					count[nx]=count[cur]+1;
				}
			}
		}
	}
}

