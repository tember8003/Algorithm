import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<arr.length; i++){
            if(i==arr.length-1){
                queue.add(arr[i]);
            }
            else{
                if(arr[i]==arr[i+1]){
                    continue;
                }
                else{
                    queue.add(arr[i]);
                }
            }
        }
        int[] answer = new int[queue.size()];
        int i=0;
        while(queue.size()>1){
            answer[i]=queue.peek();
            queue.poll();
            i++;
        }
        answer[i]=queue.peek();
        return answer;
    }
}