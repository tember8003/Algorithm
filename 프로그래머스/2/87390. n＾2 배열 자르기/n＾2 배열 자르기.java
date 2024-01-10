import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        int cnt=0;
        for(long i =left; i<=right; i++){
            long row = i/n+1;
            long col = i%n+1;
            answer[cnt++]=(int)Math.max(row,col);
        }
        return answer;
    }
}