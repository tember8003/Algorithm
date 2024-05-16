import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//비둘기집 원리를 이용한 문제
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //데이터케이스 수 입력받기
		StringTokenizer st;
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			st= new StringTokenizer(br.readLine());
			
			if(N>32) { //32보다 크면 MBTI가 세명이 겹친다 -> 거리는 0
				System.out.println(0);
				continue;
			}
			//MBTI값 입력받기
			String[] MBTI = new String[N];
			for(int j = 0; j < N; j++) {
                MBTI[j] = st.nextToken();
            }
			
			int min_value = Integer.MAX_VALUE; //가장 짧은 거리 찾기
			for(int j = 0; j<N-2; j++) {
				for(int k = j+1; k<N-1; k++) {
					for(int l=k+1; l<N; l++) {
						//세 명의 거리 구하고 최솟값인지 확인
						min_value=Math.min(min_value, findDistance(MBTI[j],MBTI[k])
								+findDistance(MBTI[k],MBTI[l])+findDistance(MBTI[j],MBTI[l]));
					}
				}
			}
			System.out.println(min_value);
		}
		
	}
	//거리 구하기
	public static int findDistance(String str1,String str2) {
		int distance=0;
		for(int i=0; i<4; i++) {
			if(str1.charAt(i)!=str2.charAt(i)) {//MBTI 하나가 다를 때마다 +1
				distance++;
			}
		}
		return distance;
	}
}
