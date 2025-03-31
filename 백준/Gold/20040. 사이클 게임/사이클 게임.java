import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			
			if(findParent(one)==findParent(two)) {
				System.out.println(i+1);
				return;
			} else {
				union(one,two);
			}
		}
		System.out.println(0);
	}
	
	public static void union(int a, int b) {
		int ap = findParent(a);
		int bp = findParent(b);
		
		if(ap!=bp) {
			arr[bp]=ap;
		}
	}
	
	public static int findParent(int x) {
		if(arr[x]==x) {
			return x;
		}
		
		return findParent(arr[x]);
	}
}
