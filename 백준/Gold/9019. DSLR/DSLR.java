import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int first_num; //처음 가진 숫자
	static int second_num; //두번째로 주어지는 숫자 = 만들어야 할 결과값
	
	static char[] command = {'D','S','L','R'}; //수행할 명령어들
	static boolean[] visited; //방문 여부 확인용
	static String[] result; //최종 명령어 결과 저장용
	
	static class Register{ //레지스터라는 이름의 클래스
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
		StringBuilder sb = new StringBuilder(); //나중에 출력을 위한 용도
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
	public static String bfs() { //BFS 실행
		Queue<Register> queue = new LinkedList<>();
		queue.offer(new Register(first_num, ""));
		
		while(!queue.isEmpty()) {
			Register reg = queue.poll();
			if(visited[reg.num]) { //방문했다면 continue
				continue;
			}
			visited[reg.num]=true;
			
			if(reg.num==second_num) { //만약 결과값이랑 같다면 해당 명령어 return
				return reg.str;
			}
			
			for(int i=0; i<4; i++) { //D S L R 명령어
				if(command[i]=='D') {
					queue.offer(new Register((reg.num*2) %10000, reg.str+"D"));
				}
				else if(command[i]=='S') {
					int numS = (reg.num == 0)? 9999: reg.num - 1;
					//reg.num==0이면 9999로 변경 아니면 reg.num-1
					queue.offer(new Register(numS, reg.str+"S"));
				}
				else if(command[i]=='L') {
					//왼쪽으로 한칸씩 밀기
					int num_L = (reg.num/1000)
							+((reg.num/100)%10)*1000+
							((reg.num/10)%10)*100+((reg.num)%10)*10;
					queue.offer(new Register(num_L, reg.str+"L"));
				}
				else { //command[i]=='R'
					//오른쪽으로 한칸씩 밀기
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
