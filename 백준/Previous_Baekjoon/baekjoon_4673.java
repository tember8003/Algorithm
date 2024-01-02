//브루트포스 알고리즘
//제목:셀프넘버
//문제 이해가 제일 어려웠던 문제. 셀프 넘버만 제껴야 하는건지 몰랐었음.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		boolean[] check=new boolean[10001];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=1; i<10001; i++) {
			int n=move(i);
			if(n<10001) {
				check[n]=true;
			}
		}
		for(int i=1; i<10001; i++) {
			if(check[i]!=true) {
				System.out.println(i);
			}
		}
	}
	public static int move(int i) {
		int sum=i;
		while(i!=0) {
			sum=sum+(i%10);
			i/=10;
		}
		return sum;
	}
}

