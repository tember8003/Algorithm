import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int ans;
	static StringBuilder sb = new StringBuilder();
	//static boolean[] visited= new boolean[10];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			ans=Integer.parseInt(br.readLine());
			dfs(1,1,1,0,"1");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int cnt,int num,int option,int sum,String s) {
		if(cnt==ans) {
			sum +=num*option;
			if(sum==0) {
				sb.append(s+"\n");
			}
			return;
		}
		dfs(cnt+1,num*10+(cnt+1),option,sum,s+" "+String.valueOf(cnt+1));
		dfs(cnt+1,cnt+1,1,sum+(num*option),s+"+"+String.valueOf(cnt+1));
		dfs(cnt+1,cnt+1,-1,sum+(num*option),s+"-"+String.valueOf(cnt+1));
	}

}
