//https://school.programmers.co.kr/learn/courses/30/lessons/147355
//int로 하면 런타임에러가 발생함. long으로 해야 런타임 에러 안생김. 문제 자체는 어렵지 않았음.

//소스 코드
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long temp=0;
        for(int i=0; i<=t.length()-p.length(); i++){
            temp=Long.parseLong(t.substring(i,i+p.length()));
            if(temp <= Long.parseLong(p)){
                answer++;
            }
        }
        return answer;
    }
}
