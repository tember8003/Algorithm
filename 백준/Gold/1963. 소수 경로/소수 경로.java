import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[] visited;
	static class Point{
		int num;
		int count;
		
		Point(int num, int count){
			this.num=num;
			this.count=count;
		}
	}
	static boolean[] sosu;
	static int target_one, target_two;
	static int count=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		isSosu();
		
		n = Integer.parseInt(br.readLine());
		while(n-->0) {
			st = new StringTokenizer(br.readLine());
			target_one = Integer.parseInt(st.nextToken());
			target_two = Integer.parseInt(st.nextToken());
			
			if(BFS()) {
				sb.append(count+"\n");
			}
			else {
				sb.append("Impossible"+"\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void isSosu() {
		sosu = new boolean[10001];
		Arrays.fill(sosu, true);
		
		sosu[0]=false;
		sosu[1]=false;
		
		for(int i=2; i<=100; i++) {
			if(sosu[i]) {
				for(int j=i*i; j<=10000; j+=i) {
					sosu[j]=false;
				}
			}
		}
	}
	
	public static boolean BFS() {
		Queue<Point> queue = new LinkedList<>();
		visited= new boolean[10000];
		visited[target_one]=true;
		queue.offer(new Point(target_one, 0));
		
		while(!queue.isEmpty()) {
			Point target = queue.poll();
			
			if(target.num==target_two) {
				count = target.count;
				return true;
			}
			
			int[] pNum = {target.num / 1000, (target.num / 100) % 10, (target.num / 10) % 10, target.num % 10};
			for(int i=0; i<4; i++) {
				for(int j=0; j<10; j++) {
					if(i==0 && j==0) {
						continue;
					}
					
					int tmp = pNum[i];
					pNum[i]=j;
					int nxt = 0;
					for(int k=0; k<4; k++) {
						nxt += (int) (pNum[k] * (Math.pow(10,3-k)));
					}
					
					pNum[i]=tmp;
					
					if(sosu[nxt] && !visited[nxt]) {
						visited[nxt]=true;
						queue.offer(new Point(nxt,target.count+1));
					}
				}
			}
		}
		return false;
	}
}
