//명코모 Beenu님 코드 참고 + Velog LCS 문서 참고
//제목:LCS
//다이나믹 프로그래밍
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] one = br.readLine().toCharArray();
		char[] two = br.readLine().toCharArray();
		int[][] table=new int[one.length+1][two.length+1];
		for(int i=1; i<=one.length; i++) {
			for(int j=1; j<=two.length; j++) {
				if(one[i-1]==two[j-1]) {
					table[i][j]=table[i-1][j-1]+1;
					continue;
				}
				table[i][j]=Math.max(table[i-1][j], table[i][j-1]);
			}
		}
		System.out.println(table[one.length][two.length]);
	}
}
