import java.util.*;
class Solution {
    long[] F = new long[100001];
    
    public long solution(int n) {
        F[0]=0; F[1]=1; F[2]=1;
        long answer = 0;
        if(n<3){
            answer=F[n];
            return answer;
        }
        else{
            for(int i=3; i<=n; i++){
                F[i]=F[i-1]+F[i-2];
                F[i]=F[i]%1234567;
            }
            answer=F[n];
            return answer;
        }
        
    }
}