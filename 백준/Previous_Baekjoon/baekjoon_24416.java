//제목:알고리즘 수업- 피보나치 수 1
//다이나믹 프로그래밍
import java.util.*;
public class Main {
	public static int fib(int n) {
		if(n==1 || n==2) {
			return 1;
		}
		else {
			return (fib(n-1)+fib(n-2));
		}
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int result=fib(n);
		int result2=n-2;
		System.out.println(result+ " "+result2);
	}
}
