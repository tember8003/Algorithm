import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	//다익스트라 알고리즘 사용
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		
		Node(int x,int y, int cost){
			this.x=x;
			this.y=y;
			this.cost=cost;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.cost - n.cost;
		}
		
	}
	static int N; //동굴 크기
	static int[][] map; //동굴 배열
	static int result; //최소 금액
	static boolean[][] visited; //방문 여부 확인
	static int[][] size; //최소 금액에 따라 동굴 배열 변경
	static int[] dx = {-1,1,0,0}; //동서남북 이동용
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int count=1;
		
		while(true) {
			result=0; //결과값
			N = Integer.parseInt(br.readLine());
			if(N==0) { //종료
				break;
			}
			map = new int[N][N];
			visited = new boolean[N][N];
			size = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					size[i][j] = Integer.MAX_VALUE;
				}
			}
			
			result = dijkstra(0,0,map[0][0]);
			sb.append("Problem " + count + ": "+ result +"\n");
			count++;
		}
		System.out.println(sb.toString());
	}
	
	public static int dijkstra(int x, int y, int roopy) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visited[x][y] = true;
		pq.offer(new Node(x,y,roopy));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x+dx[i];
				int ny = node.y+dy[i];
				
				if(check(nx,ny) && !visited[nx][ny] && size[nx][ny] > (map[nx][ny] + node.cost)) {
					//최소금액으로 수정하기 
					size[nx][ny] = map[nx][ny] + node.cost;
					visited[nx][ny] = true;
					pq.offer(new Node(nx,ny,size[nx][ny]));
				}
			}
		}
		
		return size[N-1][N-1];
	}
	public static boolean check(int x,int y) { //범위 안에 들어오는지 확인하는 함수
		if(x<N && y<N && y>=0 && x>=0 ) {
			return true;
		}
		else {
			return false;
		}
	}
}
