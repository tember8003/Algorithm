import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i=0; i<n; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp==0) {
				if(pq.isEmpty()) {
					sb.append(0+"\n");
				}
				else {
					sb.append(pq.peek()+"\n");
					pq.poll();
				}
			}
			else {
				pq.add(temp);
			}
		}
		System.out.println(sb.toString());	
	}
}
