//1렙 문제
//해시맵 이용해서 문제 해결함. containsKey를 기억하는 것이 중요해보임.
//https://school.programmers.co.kr/learn/courses/30/lessons/176963

//소스코드
import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int ans=photo.length;
        HashMap<String,Integer> maps = new HashMap<>();
        for(int i=0; i<name.length; i++){
            maps.put(name[i],yearning[i]);
        }
        int[] answer=new int[ans];
        for(int i=0; i<photo.length; i++){
            for(int j=0; j<photo[i].length; j++){
                if(maps.containsKey(photo[i][j])){
                    answer[i]+=maps.get(photo[i][j]);                    
                }
                else{
                    continue;
                }
            }
        }
        
        return answer;
    }
}
