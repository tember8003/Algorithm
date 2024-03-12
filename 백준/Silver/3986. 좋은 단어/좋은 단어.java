import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static int count=0; //좋은 단어 개수
	
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //단어 개수 입력받기.
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			WordCheck(s); //좋은 단어 맞는지 확인
		}
		System.out.println(count); //좋은 단어 개수 출력
		
	}
	public static void WordCheck(String s) {
		if(s.length()%2==1) { //만약 단어 길이가 홀수면 무조건 1개가 남아서 좋은 단어 X
			return;
		}
		Stack<Character> stack = new Stack<>();
		stack.add(s.charAt(0)); //첫번째 단어 Stack에 넣기
		for(int i=1; i<s.length(); i++) {
			if(stack.size()>0 && stack.peek()==s.charAt(i)) { //만약 짝이 있다면?
				stack.pop(); 
			}
			else {
				stack.add(s.charAt(i)); //다른 단어일 경우 넣기.
			}
		}
		if(stack.isEmpty()) { //좋은 단어가 맞다면?
			count++; //개수 + 1
		}
	}
}
