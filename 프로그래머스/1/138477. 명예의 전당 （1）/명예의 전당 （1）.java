import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] answer = new int[score.length];
        for(int i=0; i<score.length; i++){
            if(pq.size()>=k){
                if(pq.peek() < score[i]){
                    pq.poll();
                    pq.add(score[i]);
                }
            }
            else{
                pq.add(score[i]);
            }
            answer[i]=pq.peek();
        }
        return answer;
    }
}