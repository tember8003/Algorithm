//https://school.programmers.co.kr/learn/courses/30/lessons/140108
//처음에 너무 어렵게 생각했음. 훨씬 쉬운 풀이 참고함.
//https://velog.io/@sugyeonghh/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%AC%B8%EC%9E%90%EC%97%B4-%EB%82%98%EB%88%84%EA%B8%B0Java

//소스코드
import java.util.*;
class Solution {
    public int solution(String s) {
        char temp1=s.charAt(0);
        int first=0;
        int second=0;
        int answer=0;
        for(int i=0; i<s.length(); i++){
            if(first==second){
                answer++;
                temp1=s.charAt(i);
            }
            if(s.charAt(i)==temp1){
                first++;
            }
            else{
                second++;
            }
        }
        return answer;
    }
}
