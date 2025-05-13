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
		int num;
		int count;
		
		public Point(int num, int count) {
			this.num = num;
			this.count = count;
		}
	}
	static int n,m;
	static int target_one,target_two;
	static ArrayList<ArrayList<Integer>> arr;
	static boolean[] visited;
	static int count=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		target_one = Integer.parseInt(st.nextToken());
		target_two = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			arr.add(new ArrayList<>());
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			
			arr.get(one).add(two);
			arr.get(two).add(one);
		}
		
		if(BFS()) {
			System.out.println(count);
		}
		else {
			System.out.println(-1);
		}
	}
	public static boolean BFS() {
		Queue<Point> queue = new LinkedList<>();
		visited = new boolean[n+1];
		
		queue.offer(new Point(target_one,0));
		visited[target_one]=true;
		
		while(!queue.isEmpty()) {
			Point target = queue.poll();
			
			if(target.num == target_two) {
				count = target.count;
				return true;
			}
			
			for(int num : arr.get(target.num)) {
				if(!visited[num]) {
					visited[num]= true;
					queue.offer(new Point(num,target.count+1));
				}
			}
			
		}
		return false;
	}
}
