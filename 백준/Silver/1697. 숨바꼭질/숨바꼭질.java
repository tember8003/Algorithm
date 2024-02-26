import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int k;
	static int[] check = new int[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		if(n==k) {
			System.out.println(0);
		}
		else {
			bfs(n);
		}
	}
	
	static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(num);
		check[num]=1;
		while(!queue.isEmpty()) {
			int temp=queue.poll();
			for(int i=0; i<3; i++) {
				int nx;
				if(i==0) {
					nx=temp+1;
				}
				else if(i==1) {
					nx=temp-1;
				}
				else {
					nx=temp*2;
				}
				
				if(nx==k) {
					System.out.println(check[temp]);
					return;
				}
				if(nx<0 || nx>=check.length|| check[nx]!=0) {
					continue;
				}
				queue.add(nx);
				check[nx]=check[temp]+1;
			}
		}
	}
}
