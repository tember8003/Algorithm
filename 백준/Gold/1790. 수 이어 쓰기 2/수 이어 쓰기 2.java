//https://code-lab1.tistory.com/145 참고
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int K=scan.nextInt();
		long target=0;
		long length=1;
		long num=9;
		while(K>num*length) {
			K-=(num*length);
			target+=num;
			
			length++;
			num*=10;
		}
		target=(target+1)+(K-1)/length;//..?
		if(target > N) {
			System.out.println(-1);
		}
		else {
			int temp=(int)((K-1)%length);
			System.out.println(String.valueOf(target).charAt(temp));
		}
	}
}