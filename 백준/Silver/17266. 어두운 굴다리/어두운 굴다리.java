import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new int[M];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 1;
		int right = N;
		int min_num = 0;
		while(left<=right) {
			int mid = (left+right)/2;
			
			if(check(mid)) {
				right = mid-1;
				min_num = mid;
			}
			else {
				left = mid+1;
			}
		}
		
		System.out.println(min_num);
	}
	
	public static boolean check(int mid) {
		int prev = 0;
		
		for(int i=0; i<M; i++) {
			if(arr[i] - mid <= prev) {
				prev = arr[i] + mid;
			}
			else {
				return false;
			}
		}
		if(N-prev <= 0) {
			return true;
		}
		else {
			return false;
		}
	}
}