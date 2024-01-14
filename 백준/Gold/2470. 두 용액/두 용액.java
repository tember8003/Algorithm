import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] arr= new int[n];
		int ans = 2000000001;
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int right=n-1; int left=0;
		int result_left=arr[left]; int result_right=arr[right]; 
		while(left<right) {
			int sum=Math.abs(arr[right]+arr[left]);
			if(sum<ans) {
				ans=sum;
				result_right=arr[right];
				result_left=arr[left];
			}
			if(arr[right]+arr[left]<0) {
				left++;
			}
			else if (arr[right] + arr[left] > 0) {
				right--;
			}
			else if (arr[right] + arr[left] == 0){
				result_left = arr[left]; result_right = arr[right];
				break;
			}
		}
		System.out.println(result_left+" "+result_right);
	}
}	
