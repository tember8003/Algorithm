import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		long left = 1;
		long right = arr[N-1];
		long min_M = 0;
		while(left <= right) {
			long sum = 0;
			long mid = (left+right)/2;
			for(int i=0; i<N; i++) {
				if(arr[i] < mid) {
					continue;
				}
				else {
					sum += arr[i] - mid;
				}
			}
			
			if(sum >= M) {
				left = mid +1;
				min_M = Math.max(min_M, mid);
			}
			else {
				right = mid -1;
			}
		}
		System.out.println(min_M);
	}
}