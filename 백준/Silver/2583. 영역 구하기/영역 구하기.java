import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new boolean[M][N];
		
		while(K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first_x = Integer.parseInt(st.nextToken());
			int first_y = Integer.parseInt(st.nextToken());
			int last_x = Integer.parseInt(st.nextToken());
			int last_y = Integer.parseInt(st.nextToken());
			
			for(int i=first_y; i<last_y; i++) {
				for(int j=first_x; j<last_x; j++) {
					map[i][j]=1;
				}
			}
		}
		
		ArrayList<Integer> arr = new ArrayList<>();
		int ground=0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && map[i][j]==0) {
					arr.add(BFS(i,j));
					ground++;
				}
			}
		}
		
		Collections.sort(arr);
		
		System.out.println(ground);
		for(int i=0; i<ground; i++) {
			System.out.print(arr.get(i)+" ");
		}
	}
	public static void print_map() {
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static int BFS(int x,int y) {
		Queue<int[]> queue = new LinkedList<>();
		visited[x][y]=true;
		int count=1;
		
		queue.offer(new int[]{x,y});
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			for(int i=0; i<4; i++) {
				int tx = temp[0] + dx[i];
				int ty = temp[1] + dy[i];
				
				if(tx < 0 || ty < 0 || tx >=M || ty >=N) {
					continue;
				}
				
				if(!visited[tx][ty] && map[tx][ty]==0) {
					count++;
					visited[tx][ty]=true;
					queue.add(new int[] {tx,ty});
				}
			}
		}
		return count;
	}

}
