import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] person;
	static int CHECK=-1;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		person = new int[N];
		Arrays.fill(person, CHECK);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int x=0; x<N; x++) {
			int leftCount = Integer.parseInt(st.nextToken());
			
			
			int count=0;
			for(int i=0; i<N; i++) {
				if(person[i]==CHECK) {
					if(count==leftCount) {
						person[i] = x+1;
						break;
					}
					count++;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(person[i]+" ");
		}
	}

}
