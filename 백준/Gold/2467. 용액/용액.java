import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st =new StringTokenizer(br.readLine());
		int[] arr =new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int left=0; int right=n-1;
		int ans_r=0; int ans_l=0;
		int ans=Integer.MAX_VALUE;
		while(left < right) {
			int mid = arr[right]+arr[left];
			if(Math.abs(mid) < ans) {
				ans=Math.abs(mid);
				ans_r=arr[right];
				ans_l=arr[left];
			}
			if(mid<0) {
				left++;
			}
			else {
				right--;
			}
		}
		System.out.println(ans_l+" "+ans_r);
	}

}
