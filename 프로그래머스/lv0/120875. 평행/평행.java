import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[][] dots) {
             int answer = 0;
        int x1 = dots[0][0];
        int y1 = dots[0][1];
        int x2 = dots[1][0];
        int y2 = dots[1][1];
        int x3 = dots[2][0];
        int y3 = dots[2][1];
        int x4 = dots[3][0];
        int y4 = dots[3][1];
        if((double) Math.abs(y1-y2)/Math.abs(x1-x2) == (double)Math.abs(y3-y4)/Math.abs(x3-x4)) {
            answer = 1;
        }else if((double)Math.abs(y1-y3)/Math.abs(x1-x3) == (double)Math.abs(y2-y4)/Math.abs(x2-x4)) {
            answer = 1;
        }else if((double)Math.abs(y1-y4)/Math.abs(x1-x4) == (double)Math.abs(y2-y3)/Math.abs(x2-x3)) {
            answer = 1;
        }

        return answer;
    }
}