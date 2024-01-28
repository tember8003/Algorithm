import java.util.*;
class Solution {
    public int reverse(int x) {
        int answer=0;
        try{
            String[] reverse = String.valueOf(Math.abs(x)).split("");
            StringBuilder sb =new StringBuilder();
            if(x<0){
                sb.append("-");
            }
            for(int i=reverse.length-1; i>=0; i--){
                sb.append(reverse[i]);
            }
            answer=Integer.parseInt(sb.toString());
        } catch(NumberFormatException e){
            answer=0;
        }
        return answer;
    }
}