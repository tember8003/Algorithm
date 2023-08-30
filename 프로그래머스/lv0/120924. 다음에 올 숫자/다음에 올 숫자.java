import java.util.*;
class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int diff = 0;
        
        if((common[1] - common[0]) == (common[2] - common[1])){
            diff = common[1] - common[0];
            answer = common[common.length - 1] + diff;
        }
        else if((common[1] / common[0]) == (common[2] / common[1])){
            diff = common[1] / common[0];
            answer = common[common.length - 1] * diff;
        }
        return answer;
    }
}