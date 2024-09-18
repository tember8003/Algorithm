import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int x;
	int time;
	
	public Node(int x,int time) {
		this.x=x;
		this.time=time;
	}
}

public class Main {
    //bfs 풀이
	static int n;
	static int k;
	static boolean[] check = new boolean[100001];
	static int min_num = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		if(n>=k) { //n이 더 크거나 같으면 비교 의미 X
			System.out.println(n-k);
		}
		else {
			bfs(n);
			System.out.println(min_num);
		}
	}
	
	public static void bfs(int num) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(num,0));
		while(!queue.isEmpty()) {
			Node node=queue.poll();
			check[node.x]=true;
			
			if(node.x==k) { //최소 시간 찾기
				min_num = Math.min(node.time,min_num);
			}
			
            //순간이동 가능할 경우 (시간 0초 소요)
			if(node.x *2 <= 100000 && check[node.x*2]==false) {
				queue.add(new Node(node.x*2,node.time));
			}
            
            //+1 가능할 경우 (시간 1초 소요)
			if(node.x +1<=100000 && check[node.x+1]==false) {
				queue.add(new Node(node.x+1,node.time+1));
			}
            
            //-1 가능할 경우 (시간 1초 소요)
			if(node.x-1>=0 && check[node.x-1]==false) {
				queue.add(new Node(node.x-1,node.time+1));
			}
		}
	}
}
