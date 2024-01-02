//https://school.programmers.co.kr/learn/courses/30/lessons/142086?language=java
//lastIndexOf 를 사용하는게 가장 중요한 문제.

//https://velog.io/@se_bb/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4Java-%EA%B0%80%EC%9E%A5-%EA%B0%80%EA%B9%8C%EC%9A%B4-%EA%B0%99%EC%9D%80-%EA%B8%80%EC%9E%90
//참고
class Solution {
    public int[] solution(String s) {
        int[] answer =new int[s.length()];
        for(int i=0; i<s.length(); i++){
            if(i!=0){
                int index=s.substring(0,i).lastIndexOf(s.charAt(i));
                if(index!=-1){
                    answer[i]=i-index;
                }
                else{
                    answer[i]=index;
                }
                
            }
            else{
                answer[i]=-1;
            }
        }
        return answer;
    }
}
