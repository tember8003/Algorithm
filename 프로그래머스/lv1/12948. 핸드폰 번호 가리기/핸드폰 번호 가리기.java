import java.util.*;
class Solution {
    public String solution(String phone_number) {
        String temp = phone_number.substring(phone_number.length()-4);
        String answer = "";
        StringBuilder sb = new StringBuilder(answer);
        for(int i=0; i<phone_number.length()-4; i++){
            sb.append("*");
        }
        sb.append(temp);
        return sb.toString();
    }
}