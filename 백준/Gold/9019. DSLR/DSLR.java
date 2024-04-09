import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int first_num;
	static int second_num;
	
	static char[] command = {'D','S','L','R'};
	static boolean[] visited;
	static String[] result;
	
	static class Register{
		int num;
		String str;
		
		public Register(int num, String str) {
			this.num=num;
			this.str=str;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		result = new String[n];
		
		
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			first_num = Integer.parseInt(st.nextToken());
			second_num = Integer.parseInt(st.nextToken());
			
			visited = new boolean[10000];
			
			result[i] = bfs();
		}
		
		for(int i=0; i<n; i++) {
			sb.append(result[i]+"\n");
		}
		
		System.out.println(sb.toString());
	}
	public static String bfs() {
		Queue<Register> queue = new LinkedList<>();
		queue.offer(new Register(first_num, ""));
		
		while(!queue.isEmpty()) {
			Register reg = queue.poll();
			if(visited[reg.num]) {
				continue;
			}
			visited[reg.num]=true;
			
			if(reg.num==second_num) {
				return reg.str;
			}
			
			for(int i=0; i<4; i++) {
				if(command[i]=='D') {
					queue.offer(new Register((reg.num*2) %10000, reg.str+"D"));
				}
				else if(command[i]=='S') {
					int numS = (reg.num == 0)? 9999: reg.num - 1;
					queue.offer(new Register(numS, reg.str+"S"));
				}
				else if(command[i]=='L') {
					int num_L = (reg.num/1000)
							+((reg.num/100)%10)*1000+
							((reg.num/10)%10)*100+((reg.num)%10)*10;
					queue.offer(new Register(num_L, reg.str+"L"));
				}
				else { //command[i]=='R'
					int num_R = ((reg.num%10)*1000)+
							((reg.num/10)%10)+
							((reg.num/100)%10)*10+(reg.num/1000)*100;
					queue.offer(new Register(num_R, reg.str+"R"));		
				}
			}
		}
		return "";
	}
}
