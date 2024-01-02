//그리디문제
//사실 수학문제?
//문제 제목:30
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException{
		boolean check=false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num=br.readLine();
		char[] arr=num.toCharArray();
		int[] num_arr=new int[arr.length];
		int hap=0;
		for(int i=0; i<arr.length; i++) {
			num_arr[i]=arr[i]-'0';
			hap+=num_arr[i];
			if(num_arr[i]==0) {
				check=true;
			}
		}
		if(!check || hap%3!=0) {
			System.out.println(-1);
		}
		else {
			Arrays.sort(num_arr);
			for(int i=num_arr.length-1; i>=0; i--) {
				System.out.print(num_arr[i]);
			}
			System.out.println();
		}
	}
}
