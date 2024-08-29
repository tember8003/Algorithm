import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Pole { //전깃줄
	int right;
	int left;
	
	public Pole(int right,int left) {
		this.right = right;
		this.left = left;
	}
}

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Pole[] pole = new Pole[n];
		int[] dp = new int[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int right = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			pole[i] = new Pole(right,left);
		}
		
		Arrays.sort(pole, new Comparator<Pole>() { //전깃줄 오른쪽 오름차순 정렬
			public int compare(Pole p1, Pole p2) {
				return p1.left - p2.left;
			}
		});
		
		int maxNum=0;
		
		//정상적인 전깃줄 모두 구하기
		for(int i=0; i<n; i++) {
			dp[i]=1;
			for(int j=0; j<i; j++) {
				if(pole[i].right > pole[j].right) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			maxNum = Math.max(maxNum, dp[i]);
		}
		
		//전체 - 정상 전깃줄 = 없애야 하는 전깃줄
		System.out.println(n - maxNum);
	}
}
