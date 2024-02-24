import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        while(pq.peek() < K){ //스코빌 지수 확인
            
            if(pq.size() ==1){ //모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1
                return -1;
            }
            
            int first=pq.poll(); //가장 작은 수
            int second= pq.poll(); //두번째로 작은 수
            pq.add(first+second*2);
            answer++;
        }
        return answer;
    }
}
