//0렙 문제
//아스키코드 이용 , chatAt 이용했음. 어렵지 않게 해결한 문제
//https://school.programmers.co.kr/learn/courses/30/lessons/120850

//소스 코드
import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        int temp;
        int[] ans=new int[101];
        int count=0;
        for(int i=0; i<my_string.length(); i++){
            if(my_string.charAt(i)>47 && my_string.charAt(i)<58){
                temp=my_string.charAt(i)-'0';
                ans[count++]=temp;
            }
            else{
                continue;
            }
        }
        int[] answer = new int[count];
        for(int i=0; i<count; i++){
            answer[i]=ans[i];
        }
        Arrays.sort(answer);
        return answer;
    }
}
