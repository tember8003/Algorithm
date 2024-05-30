import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	//DFS 알고리즘 사용
	static int N,M;
	static int[] array; //배열
	static int[] temp; //DFS 중 숫자를 넣기 위한 임시 배열
	static StringBuilder sb = new StringBuilder(); //출력용
	
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//입력받기
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			array = new int[N];
			temp = new int[M]; //DFS에서 숫자를 넣어줄 임시 배열
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) { //배열 입력
				array[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(array);//비내림차순으로 정렬
			dfs(0,0);//DFS 실행
			
			System.out.println(sb.toString()); //결과 출력
			
		}
		
		public static void dfs(int num, int cnt) {
			if(cnt==M) { //길이가 M이 되었을 경우
				//출력용 StringBuilder에 내용 저장
				for(int i=0; i<M; i++) {
					sb.append(temp[i]+" ");
				}
				sb.append("\n");
				return;
			}

			for(int i=num; i<N; i++) {//연산 식
				temp[cnt]=array[i];
				dfs(i,cnt+1);
			}
		}
	}
