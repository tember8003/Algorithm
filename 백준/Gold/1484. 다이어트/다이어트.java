import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int G = Integer.parseInt(br.readLine());
		
		int left=1;
		int right=2;
		boolean check=false;
		
		while(right<100000) {
			int pRight = right*right;
			int pLeft = left*left;
			if(pRight-pLeft==G) {
				System.out.println(right);
				check=true;
			}
			
			if(pRight-pLeft>G) {
				left++;
			}
			else {
				right++;
			}
		}
		if(!check) {
			System.out.println(-1);
		}
	}
}
