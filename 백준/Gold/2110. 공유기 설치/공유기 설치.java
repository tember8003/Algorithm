import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int C,N;
	static int[] home;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //집 개수
		C = Integer.parseInt(st.nextToken()); //공유기 개수
		
		home = new int[N];
		for(int i=0; i<N; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(home);
		//이분 탐색을 위해선 반드시 정렬해야 함.
		
		int result = BinarySearch();
		System.out.println(result);
	}
	
	public static int BinarySearch() {
		//최소 거리를 찾기 위한 용도
		int low = 1;
		int high = home[N-1] - home[0]+1;
		
		while(low<high) { //이분 탐색 시작
			
			int mid = (low+high)/2;
			
			if(check(mid)<C) { //만약 탐색한 개수가 공유기 개수보다 작으면 ?
				high = mid; //거리 줄이기
			}
			else {//반대(탐색한 개수가 공유기 개수 이상일 경우)
				low = mid+1; //거리 늘리기
			}
			
		}
		return low-1;
	}
	
	public static int check(int mid) {
		//공유기 개수 확인용
		int count=1;
		int Lastlocation = home[0];
		
		for(int i= 1; i<home.length; i++) {
			int location = home[i];
			
			if(location - Lastlocation >= mid) {
				count++;
				Lastlocation = location;
			}
		}
		
		return count;
	}
}
