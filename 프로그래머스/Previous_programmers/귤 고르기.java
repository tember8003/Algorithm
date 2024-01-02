//HashMap 사용
//https://school.programmers.co.kr/learn/courses/30/lessons/138476?language=java

//https://velog.io/@skwx50000/JAVA-Lv2.-%EA%B7%A4%EA%B3%A0%EB%A5%B4%EA%B8%B0-41w449q7 참고

//소스 코드 
import java.util.*;
class Solution {
    HashMap<Integer,Integer>maps=new HashMap<>();
    public int solution(int k, int[] tangerine) {
        int sum=0;int answer = 0;
        for (int e : tangerine) {
            maps.put(e, maps.getOrDefault(e, 0) + 1);
        }
        List<Integer> keys = new ArrayList<>(maps.keySet());
        Collections.sort(keys, new customComparator());
        for(Integer key:keys){
            sum+=maps.get(key);
            answer++;
            if(sum>=k){
                break;
            }
        }

        return answer;
    }

    public class customComparator implements Comparator<Integer> {
        
        @Override
        public int compare(Integer o1, Integer o2) {
            return maps.get(o2).compareTo(maps.get(o1));
        }
    }
}
