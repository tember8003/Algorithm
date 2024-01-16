import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int i=0; i<=d;i+=k){
            long dtemp=(long)d*d;
            long itemp=(long)i*i;
            int maxtemp=(int)Math.sqrt(dtemp-itemp);
            answer+=(maxtemp/k)+1;
        }
        return answer;
    }
}