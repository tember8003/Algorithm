import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	//BFS 문제
	static class Node{ //X좌표와 시간을 가진다.
		int x;
		int time;
		Node(int x,int time){
			this.x=x;
			this.time=time;
		}
	}
	static int n,k;
	static boolean[] visited = new boolean[100001];
	
	//출력할 값들
	static int min_num = Integer.MAX_VALUE; //가장 빠른 시간
	static int ans=0; //방법의 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		if(n==k) {
			System.out.println(0);
			System.out.println(1);
		}
		else {
			bfs(n);
			
			System.out.println(min_num);
			System.out.println(ans);
		}
	}
	
	public static void bfs(int num) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(num,0));
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if(cur.x==k) { //위치가 k에 도달했을 경우
				if(cur.time < min_num) { //가장 빠른 시간인지 확인
					min_num = cur.time;
					ans=0;
				}
				if(cur.time == min_num) { //가장 빠른 시간이랑 같으면 방법 수 + 1
					ans++;
				}
				continue;
			}
			if(cur.x != k) {//방문 여부 처리
				visited[cur.x]=true;
			}
			if(cur.time+1<=min_num) {//-1 , +1 , *2 순간이동 처리
				if(cur.x+1<=100000 && !visited[cur.x+1]) {
					queue.add(new Node(cur.x+1, cur.time+1));
				}
				if(cur.x-1>=0 && !visited[cur.x-1]) {
					queue.add(new Node(cur.x-1, cur.time+1));
				}
				if(cur.x*2<=100000 && !visited[cur.x*2]) {
					queue.add(new Node(cur.x*2,cur.time+1));
				}
			}
			
		}
		
	}
}
