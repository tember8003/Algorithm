import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		long left=1;
		long right=arr[n-1];
		long result=0;
		while(left<=right) {
			long sum=0;
			long mid=(left+right)/2;
			for(int i=0; i<n; i++) {
				if(arr[i] < mid) {
					continue;
				}
				else {
					sum+=arr[i]-mid;
				}
			}
			if(sum >=m) {
				left=mid+1;
				if(result < mid) {
					result = mid;
				}
			}
			else {
				right=mid-1;
			}
		}
		System.out.println(result);
	}

}
