import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] tree = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(tree,Collections.reverseOrder());
		
		int num = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			num = Math.max(num, tree[i]+i+1);
		}
		
		System.out.println(num+1);
	}

}
