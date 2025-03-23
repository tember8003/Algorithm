import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] num = new int[N];
		
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(num);
		
		int count_num = (int) Math.round(N*0.15);
		
		int result=0;
		int count=0;
		for(int i=count_num; i<N-count_num; i++) {
			result += num[i];
			count ++;
		}
		
		System.out.println(Math.round((float)result / count));
	}
}
