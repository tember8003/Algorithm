//삼중 for문 이용
//https://school.programmers.co.kr/learn/courses/30/lessons/131705
//1단계 문제

//소스코드
class Solution {
    public int solution(int[] number) {
        int answer = 0;
        for(int i=0; i<number.length; i++){
            for(int j=i+1; j<number.length; j++){
                for(int k=j+1; k<number.length; k++){
                    if(number[i]+number[j]+number[k]==0){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
