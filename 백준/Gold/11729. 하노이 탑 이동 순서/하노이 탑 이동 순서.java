import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int n;
	static int height;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		height = (int)(Math.pow(2, n)-1);
		System.out.println(height);
		repeat(n,1,2,3);
		System.out.println(sb.toString());
	}
	static void repeat(int cnt,int start,int via,int end) {
		if(cnt==1) {
			sb.append(start+" "+end+"\n");
		}
		else {
			repeat(cnt-1,start,end,via);
			sb.append(start+" "+end+"\n");
			repeat(cnt-1,via,start,end);
		}
		return;
	}
}
