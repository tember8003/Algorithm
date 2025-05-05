import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,w,l;
	static Queue<Integer> queue = new LinkedList<>();
	static Queue<Integer> bridge = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			queue.add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < w; i++) {
			bridge.add(0);
		}
		
		int ans=0;
		int weight=0;
		while(!bridge.isEmpty()) {
			ans++;
			weight -= bridge.poll();
			
			if(queue.isEmpty()) {
				continue;
			}
			
			if(queue.peek() + weight <= l) {
				int cur = queue.poll();
				weight += cur;
				bridge.add(cur);
			} else {
				bridge.add(0);
			}
		}
		
		System.out.println(ans);
	}

}