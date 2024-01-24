import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int temp_n=n;
        int temp_k=k;
        for(int i=0; i<enemy.length; i++){
            temp_n-=enemy[i];
            pq.add(enemy[i]);
            if(temp_n<0){
                if(temp_k>0&&!pq.isEmpty()){
                    temp_n +=pq.poll();
                    temp_k--;
                }
                else{
                    answer=i;
                    break;
                }
            }
        }
        return answer;
    }
}