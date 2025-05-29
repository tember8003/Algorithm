import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			for(long nxt : findNum(num)) {
				sb.append(nxt+" ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static List<Long> findNum(int num){
		ArrayList<Long> ans = new ArrayList<>();
		ArrayList<Long> fibonacci = new ArrayList<>();
		
		fibonacci.add((long) 0);
		fibonacci.add((long) 1);
		
		int i =2;
		while(true) {
			Long next = fibonacci.get(i-1)+fibonacci.get(i-2);
			
			if(next > num) {
				break;
			}
			
			fibonacci.add(next);
			i++;
		}
		
		int temp = num;
		for(int j=fibonacci.size()-1; j>0; j--) {
			if(temp >= fibonacci.get(j)) {
				temp -= fibonacci.get(j);
				ans.add(fibonacci.get(j));
			}
		}
		
		Collections.sort(ans);
		return ans;
	}
}