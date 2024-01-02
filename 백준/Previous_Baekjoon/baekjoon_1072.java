//이분탐색
//제목:게임

import java.util.Scanner;

public class Main {

	public static long x,y,z;
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		x = scan.nextLong();
		y = scan.nextLong();

		z = y * 100 / x;
		
		if(z >= 99)
			System.out.println(-1);
		else {
			long left = 0;
			long right = x;
			while(left <= right) {
				long mid = (left + right) / 2;
				if(z < 100 * (y + mid) / (x + mid)) {
					right = mid - 1;
				}else {
					left = mid + 1;
				}
			}
			System.out.println(left);
		}
		scan.close();
	}

}

//원래 썻던 코드인데 답이 안나옴... 
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class temp {
	static long x,y,z;
	public static void main(String[] args) throws IOException{
		long mid;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		x = Long.parseLong(st.nextToken());
		y= Long.parseLong(st.nextToken());
		
		z = 100*y/x;
		if(x==y || z>99) {
			System.out.println("-1");
		}
		else {
		long low=0; long high = x;
		while (low <= high) {
			mid = (low+high)/2;
			long per = 100*(y+mid)/(x+mid);
			if(per > z) {
				high=mid-1;
			}
			else {
				low=mid+1;
			}
		}
		System.out.println(low);
		}
	}

}
*/
