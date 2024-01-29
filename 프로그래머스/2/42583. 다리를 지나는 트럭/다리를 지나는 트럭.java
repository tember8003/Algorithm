import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<Integer>();
        int sum=0;
        int time=0;
        for(int i=0; i<truck_weights.length; i++){
            while(true){
                if(bridge.isEmpty()){
                    bridge.add(truck_weights[i]);
                    sum+=truck_weights[i];
                    time++;
                    break;
                }
                else if(bridge.size()==bridge_length){
                    sum-=bridge.poll();
                }
                else{
                    if(sum+truck_weights[i] <= weight){
                        bridge.add(truck_weights[i]);
                        sum+=truck_weights[i];
                        time++;
                        break;
                    }
                    else{
                        bridge.add(0);
                        time++;
                    }
                }
            }
        }
        int answer = bridge_length+time;
        return answer;
    }
}