import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> queue = new LinkedList<>();
        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length; i++){
            queue.add(prices[i]);
        }
        
        int idx=0;
        while(!queue.isEmpty()){
            int currentPrice=queue.poll();
            for(int i=(prices.length - queue.size()); i<prices.length; i++){
                if(currentPrice > prices[i]){ //가격이 떨어졌다면?
                    answer[idx]++;
                    break;
                }
                else{ //가격이 떨어지지 않았다면?
                    answer[idx]++;
                }
            }
            idx++;
        }
        return answer;
    }
}