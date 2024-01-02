//https://devmoony.tistory.com/169 참고
//처음엔 약수 구하는 알고리즘을 메소드로 따로 만들었으나, 자꾸 오류가 나와서 고침
//https://school.programmers.co.kr/learn/courses/30/lessons/136798

//소스 코드
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] result = new int[number+1];
        for(int i=0; i<number; i++){
            int cnt=0;
            for(int j=1; j*j<=i+1; j++){
                if(j*j==i+1){
                    cnt++;
                }
                else if((i+1) % j==0){
                    cnt+=2;
                }
        }
            result[i]=cnt;
            if(result[i]>limit){
                result[i]=power;
            }
            answer+=result[i];
        }
        return answer;
    }
}
