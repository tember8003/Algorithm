import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        int size=citations.length;
        for(int i=0; i<size; i++){
            if(citations[i] >= size - i){
               answer=size-i;
                break;
            }
        }
        
        return answer;
    }
}