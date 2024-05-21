import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	//Deque를 사용해서 해결하는 문제
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> deque; //Deque 선언
		StringTokenizer st; //문자열 입력 받아 원하는 값만 도출하기 위해서
		StringBuilder sb= new StringBuilder(); //출력용
		 	
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수 입력받기
		
		String command; //실행할 함수 P
		int n; //배열 수
		boolean reverseCheck; //뒤집힌 문자열인지 아닌지 체크
		boolean errorCheck; //error가 나와야 하는 상황인지 아닌지 체크
		
		for(int i=0; i< T; i++) {
			errorCheck=false;
			reverseCheck=false; //처음엔 뒤집히지 않음
			deque = new ArrayDeque<>(); //deque 생성
			
			command = br.readLine(); //함수 p 입력받기
			n=Integer.parseInt(br.readLine()); //배열 수 입력받기
			st = new StringTokenizer(br.readLine(),"[],");//구분할 문자들 처리 '[' 그리고 ']' 그리고 ',' 제외
			for(int j=0; j<n; j++) {
				deque.add(Integer.parseInt(st.nextToken())); //deque에 입력시키기
			}
			for(int j=0; j<command.length(); j++) {
				if(command.charAt(j)=='R') { //R일 경우
					if(reverseCheck==false) { //뒤집히지 않았다면?
						reverseCheck=true; //뒤집힘
					}
					else { //뒤집혔다면 ?
						reverseCheck=false; //뒤집지 않음
					}
				}
				else if(command.charAt(j)=='D'){ //D일 경우
					if(deque.size()==0) { //deque에 아무것도 없다면
						errorCheck=true; //에러가 나와야 함
						sb.append("error\n");
						break;
					}
					if(!reverseCheck) { //뒤집히지 않았다면
						deque.removeFirst(); //첫번째 값 제거
					}
					else { //뒤집혔다면
						deque.removeLast(); //마지막 값 제거
					}
				}
			}
			//출력하기
			if(!errorCheck) { //에러가 아니라면
				//뒤집혔는지 아닌지에 따라 출력 방식 다름 
				if(!reverseCheck && deque.size()!=0) { //뒤집히지 않았다면
					//첫번째 값부터 순서대로 출력하기
					sb.append("[");
					sb.append(deque.getFirst());
					deque.removeFirst(); 
					while(deque.size()!=0) {
						sb.append(",");
						sb.append(deque.getFirst());
						deque.removeFirst();
					}
					sb.append("]\n");
				}
				else if(reverseCheck && deque.size()!=0){//뒤집혔다면
					//마지막 값에서부터 처음 값으로 역순으로 출력하기
					sb.append("[");
					sb.append(deque.getLast());
					deque.removeLast();
					while(deque.size()!=0) {
						sb.append(",");
						sb.append(deque.getLast());
						deque.removeLast();
					}
					sb.append("]\n");
				}
				else { //만약 size는 0인데 에러는 아닌 상황이면
					sb.append("[]\n");
				}
			}
		}		
		System.out.println(sb.toString()); //최종 출력	
	}
}
