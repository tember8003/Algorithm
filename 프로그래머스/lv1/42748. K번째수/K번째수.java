import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int left=0; int right=0;
        for(int i=0; i<commands.length; i++){
            int k=0;
            left=commands[i][0];
            right=commands[i][1];
            int[] temp= new int[right-left+1];
            for(int j=left; j<=right; j++){
                temp[k++]=array[j-1];
            }
            Arrays.sort(temp);
            answer[i]=temp[commands[i][2]-1];
        }
        return answer;
    }
}