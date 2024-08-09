import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
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
			//각각 수 입력받음 ->숫자 / 스트라이크 / 볼
			int num = Integer.parseInt(st.nextToken());
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			
			for(int j=100; j<=999; j++) { //그 숫자와 100~999까지 모든 숫자를 비교함.
				
				if(!number[j]) {
					//이미 걸러진 숫자는 필요 X
					continue;
				}
				String temp_j = Integer.toString(j); //숫자 String화
				String temp_num = Integer.toString(num); //입력받은 숫자 String화
				int countStrike = 0; int countBall = 0; //count용도
				
				for(int k=0; k<temp_num.length(); k++) {
					for(int l=0; l<temp_num.length(); l++) {
						if(k==l && temp_j.charAt(k)==temp_num.charAt(l)) { //만약 서로 자릿수가 같고, 그 자릿수의 숫자까지 같다면??
							countStrike++; //스트라이크 카운트 + 1
						}
						if(k != l && temp_j.charAt(k)== temp_num.charAt(l)) { //만약 서로 자릿수는 다르지만 숫자가 같은 수라면??
							countBall++; //볼 카운트 + 1
						}
					}
				}
				
				if(countStrike != strike || countBall != ball) { //입력 받았던 스트라이크, 볼이랑 카운트한 스트라이크, 볼이랑 다르면 false
					number[j]=false;
				}
			}
		}
		
		
		for(int i=100; i<=999; i++) {
			if(number[i]) { //true인 숫자만 체크해줌
				answer++;
			}
		}
		System.out.println(answer); //답!!!
	}
	
	public static void Initialize() { //사전 초기화 1~9까지 서로 다른 수여야 함
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
