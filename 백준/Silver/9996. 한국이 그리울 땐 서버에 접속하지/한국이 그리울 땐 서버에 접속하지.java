import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//문자열 문제
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(),"*"); //패턴 * 기준으로 가르기
		String str_front = st.nextToken(); //* 앞부분
		String str_back = st.nextToken(); //* 뒷부분
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			
			if(str_front.length() + str_back.length() > str.length()) { //만약 패턴 비교할 문자열이 패턴 문자열보다 짧으면?
				sb.append("NE\n");
				continue;
			}
			
			String front = 	str.substring(0,str_front.length()); //* 앞부분과 비교할 앞부분
			String back = str.substring(str.length() - str_back.length(),str.length()); //* 뒷부분과 비교할 뒷부분
			
			if(str_front.equals(front) && str_back.equals(back)) {
				sb.append("DA\n");
			}
			else {
				sb.append("NE\n");
			}
		}
		System.out.println(sb.toString());
	}
}
