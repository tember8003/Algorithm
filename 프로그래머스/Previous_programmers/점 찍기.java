//수학,구현 문제
//https://school.programmers.co.kr/learn/courses/30/lessons/140107
//https://velog.io/@qodlstjd12/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A0%90%EC%B0%8D%EA%B8%B0-Java 참고
//처음엔 이중for문으로 접근했으나, 예제만 맞고 나머진 틀렸음. -> 다른 풀이를 찾아보던 중 알게 됨. 

//소스코드
import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int i=0; i<=d;i+=k){
            long dtemp=(long)d*d;
            long itemp=(long)i*i;
            int maxtemp=(int)Math.sqrt(dtemp-itemp);
            answer+=(maxtemp/k)+1; //이 생각 못했음;;;
        }
        return answer;
    }
}
