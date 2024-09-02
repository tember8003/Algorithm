import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	//구현 문제
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n =Integer.parseInt(br.readLine());
		
		char[][] map = new char[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j+1] = str.charAt(j);
			}
		}
		
		int x = 0;
		int y = 0;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(map[i][j]=='*') {
					if(map[i-1][j]=='*' && map[i][j-1] == '*' && map[i+1][j]=='*' && map[i][j+1]=='*') {
						x = i;
						y = j;
						break;
					}
				}
			}
		}
		sb.append(x+" "+y+"\n");
		
		int ans = 0;
		for(int i=y-1; i>=1; i--) {
			if(map[x][i]=='*') {
				ans++;
			}
		}
		
		sb.append(ans+" ");
		
		ans=0;
		for(int i=y+1; i<=n; i++) {
			if(map[x][i]=='*') {
				ans++;
			}
		}
		
		sb.append(ans+" ");
		
		ans=0;
		int start_x=0;
		for(int i=x+1; i<=n; i++) {
			if(map[i][y]=='*') {
				ans++;
				start_x=i;
			}
		}
		
		sb.append(ans+" ");
		
		ans=0;
		for(int i=start_x+1; i<=n; i++) {
			if(map[i][y-1]=='*') {
				ans++;
			}
		}
		
		sb.append(ans+" ");
		
		ans=0;
		for(int i=start_x+1; i<=n; i++) {
			if(map[i][y+1]=='*') {
				ans++;
			}
		}
		
		sb.append(ans);
		
		System.out.println(sb.toString());
	}
}
