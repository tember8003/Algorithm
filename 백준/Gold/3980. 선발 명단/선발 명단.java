import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static int[][] member = new int[11][11];
	static boolean[] visited= new boolean[11];
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n=Integer.parseInt(br.readLine());
		while(n>0) {
			for(int i=0; i<11; i++) {
				String[] s = br.readLine().split(" ");
				for(int j=0; j<11; j++) {
					member[i][j]=Integer.parseInt(s[j]);
				}
			}
			repeat(0,0);
			sb.append(ans).append("\n");
			ans=0;
			Arrays.fill(visited, false);
			n--;
		}
		System.out.println(sb.toString());
	}
	public static void repeat(int cnt,int sum) {
		if(cnt==11) {
			if(sum>ans) {
				ans=sum;
			}
			return;
		}
		for(int i=0; i<11; i++) {
			if(visited[i]) {
				continue;
			}
			if(member[cnt][i]==0) {
				continue;
			}
			visited[i]=true;
			repeat(cnt+1,sum+member[cnt][i]);
			visited[i]=false;
		}
	}
}
