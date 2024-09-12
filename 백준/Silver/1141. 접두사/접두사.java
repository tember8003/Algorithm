import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
	//그리디 알고리즘 문제
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] words = new String[N];
		
		for(int i=0; i<N; i++) {
			words[i] = br.readLine();
		}
		
		//문자열 내림차순 정렬하기
		Arrays.sort(words,new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str1.length()-str2.length();
			}
		});
		
		int result=N;
		
		//만약 문자열이 접두사형태면 하나씩 지워간다.
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(words[j].startsWith(words[i])) {
					result--;
					break;
				}
			}
		}
		
		//최대 접두사 X 집합 크기
		System.out.println(result);
	}	
}
