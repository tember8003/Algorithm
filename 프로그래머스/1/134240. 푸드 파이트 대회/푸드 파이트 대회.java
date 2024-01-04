import java.util.*;
class Solution {
    public String solution(int[] food) {
        for(int i=1; i<food.length; i++){
            if(food[i]%2==1){
                food[i]--;
            }
        }
        String answer = "";
        String temp="";
        for(int i=1; i<food.length; i++){
            for(int j=0; j<food[i]/2;j++){
                temp+=Integer.toString(i);
            }
        }
        //https://hianna.tistory.com/543 문자열 거꾸로 뒤집기 참고
        StringBuffer sb = new StringBuffer(temp);
        String reverse = sb.reverse().toString();
        answer=temp+"0"+reverse;
        return answer;
    }
}