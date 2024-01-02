//제목:문자열 집합
//문자열

import java.util.Scanner;
//백준 14425
public class Main {
	public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	int n,m;
	int count=0;
	n=scan.nextInt();
	m=scan.nextInt();
	String arr1[]=new String[n];
	String arr2[]=new String[m];
	for(int i=0; i<n; i++) {
		arr1[i]=scan.next();
	}
	for(int i=0; i<m; i++) {
		arr2[i]=scan.next();
	}
	for(int i=0; i<n; i++) {
		for(int j=0; j<m; j++) {
			if(arr1[i].equals(arr2[j])) {
				count++;
				continue;
			}
		}
	}
	System.out.println(count);
	}
	
}
