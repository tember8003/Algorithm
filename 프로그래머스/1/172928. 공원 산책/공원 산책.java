import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        //int[] answer = new int[2];
        int start_x=0; int start_y=0;
        char[][] map = new char[park.length][park[0].length()];
        for(int i=0; i<park.length; i++){
            map[i]=park[i].toCharArray();
            if(park[i].contains("S")){
                start_y=i;
                start_x=park[i].indexOf("S");
            }
        }
        for(int i=0; i<routes.length; i++){
            String way = routes[i].split(" ")[0];
            int len = Integer.parseInt(routes[i].split(" ")[1]);
            int temp_x = start_x;
            int temp_y = start_y;
            for(int j=0; j<len; j++){
                if(way.equals("E")){
                    temp_x++;
                }
                if(way.equals("N")){
                    temp_y--;
                }
                if(way.equals("W")){
                    temp_x--;
                }
                if(way.equals("S")){
                    temp_y++;
                }
                if(temp_x>=0 && temp_y >=0&& temp_y<map.length&&temp_x<map[0].length){
                    if(map[temp_y][temp_x]=='X'){
                        break;
                    }
                    if(j==len-1){
                        start_x=temp_x;
                        start_y=temp_y;
                    }
                }
            }
        }
        int[] answer={start_y,start_x};
        return answer;
    }
}