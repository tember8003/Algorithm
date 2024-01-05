import java.util.*;
class Solution {
    static List<String> list;
    static String[] words={"A","E","I","O","U"};
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        dfs("",0);
        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals(word)){
                answer=i;
                break;
            }
        }
        return answer;
    }
    static void dfs(String s,int cnt){
        list.add(s);
        if(cnt==5){
            return;
        }
        for(int i=0; i<5; i++){
            dfs(s+words[i],cnt+1);
        }
    }
}