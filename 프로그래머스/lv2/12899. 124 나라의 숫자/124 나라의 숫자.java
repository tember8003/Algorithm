import java.util.*;
class Solution {
    public String solution(int n) {
        
        String answer = "";
        while(n>0){
            if(n%3==0){
                answer+="4";
                n=n/3-1;
            }
            else{
                answer+=Integer.valueOf(n%3);
                n=n/3;
            }
        }
        StringBuffer sb=new StringBuffer(answer);
        String ans=sb.reverse().toString();
        return ans;
    }
}