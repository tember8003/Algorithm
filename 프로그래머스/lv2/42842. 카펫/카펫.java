import java.util.*;
//https://easybrother0103.tistory.com/110 참고
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int s=brown+yellow;
        for(int i=3; i<s; i++){
            int j=s/i;
            if(s%i==0 && j>=3){
                int h=Math.max(i,j);
                int w=Math.min(i,j);
                int area=(w-2)*(h-2);
                if(area==yellow){
                    answer[0]=h;
                    answer[1]=w;
                    return answer;
                }
            }
        }
        return answer;
    }
}