import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static int n;
	static ArrayList<ArrayList<Integer>> graph;
	static ArrayList<Point> point;  
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			point = new ArrayList<>();
			graph = new ArrayList<>();
			
			for(int i=0; i<n+2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				point.add(new Point(x,y));
			}
			
			for(int i=0; i<n+2; i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i=0; i<n+2; i++) {
				for(int j=i+1; j<n+2; j++) {
					if(calculate(point.get(i),point.get(j))<=1000) {
						graph.get(i).add(j);
						graph.get(j).add(i);
					}
				}
			}
			sb.append((BFS(n) ? "happy" : "sad")+"\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int calculate(Point p1, Point p2) {
		return Math.abs(p1.x-p2.x) + Math.abs(p1.y - p2.y);
	}
	
	public static boolean BFS(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		
		boolean[] visited = new boolean[n + 2];
		visited[0]=true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			if(now == n+1) {
				return true;
			}
			
			for(int next : graph.get(now)) {
				if(!visited[next]) {
					visited[next]=true;
					queue.offer(next);
				}
			}
		}
		return false;
	}
}
