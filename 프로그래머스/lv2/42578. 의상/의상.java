import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String,Integer> maps = new HashMap<String,Integer>();
        for(String[] cloth:clothes){
            String type=cloth[1];
            maps.put(type,maps.getOrDefault(type,0)+1);
        }
        Iterator<Integer> it=maps.values().iterator();
        int answer = 1;
        while(it.hasNext()){
            answer*=it.next().intValue()+1;
        }
        return answer-1;
    }
}