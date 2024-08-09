import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[] number = new boolean[1000];
	static int answer=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Arrays.fill(number, true);
		
		Initialize();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			
			for(int j=100; j<=999; j++) {
				if(!number[j]) {
					continue;
				}
				String temp_j = Integer.toString(j);
				String temp_num = Integer.toString(num);
				int countStrike = 0; int countBall = 0;
				
				for(int k=0; k<temp_num.length(); k++) {
					for(int l=0; l<temp_num.length(); l++) {
						if(k==l && temp_j.charAt(k)==temp_num.charAt(l)) {
							countStrike++;
						}
						if(k != l && temp_j.charAt(k)== temp_num.charAt(l)) {
							countBall++;
						}
					}
				}
				
				if(countStrike != strike || countBall != ball) {
					number[j]=false;
				}
			}
		}
		
		
		for(int i=100; i<=999; i++) {
			if(number[i]) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	public static void Initialize() {
		for(int i=100; i<=999; i++) {
			String temp = Integer.toString(i);
			if(temp.charAt(0)== temp.charAt(1) || temp.charAt(1)==temp.charAt(2) || temp.charAt(2)==temp.charAt(0)) {
				number[i]=false;
			}
			if(temp.charAt(0)=='0' || temp.charAt(1)=='0' || temp.charAt(2)=='0') {
				number[i]=false;
			}
		}
	}

}
