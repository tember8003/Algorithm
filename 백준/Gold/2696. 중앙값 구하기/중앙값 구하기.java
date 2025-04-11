import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		
		StringTokenizer st=null;
		while(T-->0) {
			int M = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> max_queue = new PriorityQueue<>(Comparator.reverseOrder());
			PriorityQueue<Integer> min_queue = new PriorityQueue<>();
			
			sb.append((M+1)/2+"\n");
			
			int cnt=0;
			for(int i=0; i<M; i++) {
				if(i%10 == 0) {
					st = new StringTokenizer(br.readLine());
				}
				int temp = Integer.parseInt(st.nextToken());
				
				if(max_queue.size()==min_queue.size()) {
					max_queue.offer(temp);
				}
				else {
					min_queue.offer(temp);
				}
				
				if(!min_queue.isEmpty()) {
					if(max_queue.peek() > min_queue.peek()) {
						int queue1 = max_queue.poll();
						int queue2 = min_queue.poll();
						
						max_queue.offer(queue2);
						min_queue.offer(queue1);
					}
				}
				
				if(i%2==0) {
					if(cnt==9 || i==M-1) {
						sb.append(max_queue.peek()+"\n");
					}
					else {
						sb.append(max_queue.peek()+" ");
					}
					cnt++;
				}
			}
		}
		
		System.out.println(sb.toString());
	}

}
