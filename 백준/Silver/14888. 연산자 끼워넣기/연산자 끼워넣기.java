import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int[] arr;
	public static int[] cal;
	public static int minnum=1000000001;
	public static int maxnum=-1000000001;
	//static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr=new int[n];
		cal=new int[4];
		String temp=br.readLine();
		StringTokenizer st = new StringTokenizer(temp," ");
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		temp=br.readLine();
		st= new StringTokenizer(temp," ");
		for(int i=0; i<4; i++) {
			cal[i]=Integer.parseInt(st.nextToken());
		}
		calculate(1,arr[0],cal[0],cal[1],cal[2],cal[3]);
		System.out.println(maxnum);
		System.out.println(minnum);
	}
	static void calculate(int cnt,int sum,int plus,int minus,int mul,int div) {
		if(cnt==n) {
			maxnum=Math.max(maxnum, sum);
			minnum=Math.min(minnum, sum);
			return;
		}
		if(plus>0) {
			calculate(cnt+1,sum+arr[cnt],plus-1,minus,mul,div);
		}
		if(minus>0) {
			calculate(cnt+1,sum-arr[cnt],plus,minus-1,mul,div);
		}
		if(mul>0) {
			calculate(cnt+1,sum*arr[cnt],plus,minus,mul-1,div);	
		}
		if(div>0) {
			calculate(cnt+1,(int)(sum/arr[cnt]),plus,minus,mul,div-1);
		}
		
	}

}
