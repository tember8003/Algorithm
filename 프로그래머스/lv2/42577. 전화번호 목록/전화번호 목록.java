import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String,Integer> maps=new HashMap<>();
        for(int i=0; i<phone_book.length; i++){
            maps.put(phone_book[i],1);
        }
        for(int i=0; i<phone_book.length; i++){
            for(int j=0; j<phone_book[i].length(); j++){
                if(maps.containsKey(phone_book[i].substring(0,j)))
                    return false;
            }
        }
        return answer;
    }
}