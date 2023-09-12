import java.util.*;
class Solution {
    public long solution(long n) {
        String[] str=String.valueOf(n).split("");
        Arrays.sort(str);
        StringBuilder sb=new StringBuilder();
        for(String temp:str){
            sb.append(temp);
        }
        return Long.parseLong(sb.reverse().toString());
    }
}