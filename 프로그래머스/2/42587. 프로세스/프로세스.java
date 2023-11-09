import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        //Queue<Integer> queue = new LinkedList<>();
        //LinkedHashMap<Integer,Integer> map = new HashMap<>();
        int answer=0;
        for(int i=0; i<priorities.length; i++){
            pQ.offer(priorities[i]);
        }
        while(!pQ.isEmpty()){
            for(int i=0;i<priorities.length; i++){
                int first=pQ.peek();
                if(first==priorities[i]){
                    pQ.poll();
                    answer++;
                    if(i==location){
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}