import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,S;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left=0; int right=0;
		long result=100000000;
		long hap = 0;
		while(left<=right) {
			if(hap>=S) {
				result = Math.min(result, right-left);
				hap-=arr[left];
				left++;
			}
            else if(right==N){
              break;
            }
			else {
				hap+=arr[right];
				right++;
			}
		}

		if(result==100000000) {
			System.out.println(0);
		}
		else {
			System.out.println(result);
		}
	}
}
