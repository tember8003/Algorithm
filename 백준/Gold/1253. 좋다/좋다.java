import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	//투포인터 방식?
	static int N;
	static int[] num;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		int result = BinarySearch(); //이분탐색같지만... 우선 투포인터로 해결
		System.out.println(result);
		
	}
	public static int BinarySearch() {
		int count=0;
		
		//완전탐색 형태를 사용함. (low와 high를 통해 하나씩 검사하는 형태)
		for(int i=num.length-1; i>=0; i--) {
			int low = 0;
			int high = num.length-1;
			
			if(low==i) {//값을 비교할 순서가 같으면 안됨.
				low++;
			}
			
			if(high==i) {//값을 비교할 순서가 같으면 안됨.
				high--;
			}
			
			if(low>high || low==high) { //경계 지나면 continue
				continue;
			}
			
			boolean check = false;
			
			while(true) {
				if(num[low]+num[high]>num[i]) {
					high--;
					if(high==i) {
						high--;
					}
				}
				else if(num[low]+num[high]<num[i]) {
					low++;
					if(low==i) {
						low++;
					}
				}
				else { //만약 두 값을 더한 값이 존재하면 개수 추가
					check=true;
					break;
				}
				if(low > high || low == high) { //경계 지나면 break
					break;
				}
			}
			if(check) {
				count++;
			}
		}
		
		return count;
	}
}
