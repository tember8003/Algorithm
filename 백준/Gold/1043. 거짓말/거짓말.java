import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] parents;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		int know = Integer.parseInt(st.nextToken());
		if(know==0) {
			System.out.println(M);
			return;
		}
		else {
			for(int i=0; i<know; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		ArrayList<Integer>[] party = new ArrayList[M];
		for(int i=0; i<M; i++) {
			party[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			party[i].add(one);
			for(int j=1; j<num; j++) {
				int two = Integer.parseInt(st.nextToken());
				union(one,two);
				party[i].add(two);
			}
		}
		
		int count = 0;
		for(int i=0; i<M; i++) {
			boolean check = true;
			for(int num: party[i]) {
				if(list.contains(findParent(parents[num]))) {
					check=false;
					break;
				}
			}
			
			if(check) {
				count++;
			}
		}
		System.out.println(count);

	}
	public static int findParent(int x) {
        if(x == parents[x])
            return parents[x];
        else
            return findParent(parents[x]);
    }
	public static void union(int x, int y) {
        int nx = findParent(x);
        int ny = findParent(y);
        if(list.contains(ny)) {
        	int temp = nx;
        	nx = ny;
        	ny = temp;
        }
        
        parents[ny] = nx;
    }
}
