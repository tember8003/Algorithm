import java.util.*;

class Solution {
    public long solution(long r1, long r2) {
        long answer = 0;
        for(int i=1; i<r2; i++){
            if(i<r1){
                answer+=check(i,r2,"r2")-check(i,r1,"r1");
            }
            else{
                answer+=check(i,r2,"r2");
            }
        }
        answer*=4;
        answer +=(r2-r1+1)*4;
        return answer;
    }
    public int check(long x,long r,String name){
    double temp=Math.sqrt(r*r-x*x);
    int maxInt = (int)temp;
    if(name.equals("r1") && temp - maxInt==0.0){
        return maxInt -1;
    }
    return maxInt;
}
}