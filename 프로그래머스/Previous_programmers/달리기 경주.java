//1렙 문제
//해시 맵을 이용해 접근, 풀려고 했으나 풀리지 않아서 다른 사람 풀이를 참고했음.
//https://school.programmers.co.kr/learn/courses/30/lessons/178871

//소스 코드
import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
		 Map<String, Integer> playersMap = new HashMap<>();
		 for(int i=0; i<players.length; i++){
             playersMap.put(players[i], (i+1));
         }
        for(int i=0; i<callings.length; i++){
            String temp="";
            temp=players[playersMap.get(callings[i])-2];
            players[playersMap.get(callings[i])-2]=players[playersMap.get(callings[i])-1];
            players[playersMap.get(callings[i])-1]=temp;
            
            playersMap.put(callings[i],playersMap.get(callings[i])-1);
            playersMap.put(temp,playersMap.get(temp)+1);
        }
        return players;
    }
}
