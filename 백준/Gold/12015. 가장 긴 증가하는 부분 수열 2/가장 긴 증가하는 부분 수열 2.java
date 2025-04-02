import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static int[] LCS;
	static int count=1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		LCS = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		LCS[0] = arr[0];
		
		for(int i=1; i<N; i++) {
			int key = arr[i];
			
			if(LCS[count-1]<key) {
				count++;
				LCS[count-1]=key;
			}
			else {
				int low = 0;
				int high = count;
				
				while(low < high) {
					int mid = (low+high)/2;
					if(LCS[mid] < key) {
						low = mid+1;
					}
					else {
						high=mid;
					}
				}	
				
				LCS[low]=key;
			}
		}
		System.out.println(count);
	}
}
