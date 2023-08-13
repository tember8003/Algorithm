//다른사람 풀이 참고했음. -> 가장 좋아요 많이 받은 풀이 참고
import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] x={0,0,0,0,0,0,0,0,0,0};
        int[] y={0,0,0,0,0,0,0,0,0,0};
        for(int i=0; i<X.length(); i++){
            x[X.charAt(i)-48]++;
        }
        for(int i=0; i<Y.length(); i++){
            y[Y.charAt(i)-48]++;
        }
        for(int i=9; i>=0; i--){
            for(int j=0; j<Math.min(x[i],y[i]); j++){
                answer.append(i);
            }
        }
        if("".equals(answer.toString())){
            return "-1";
        }
        else if(answer.toString().charAt(0)==48){
            return "0";
        }
        else{
            return answer.toString();
        }
    }
}
