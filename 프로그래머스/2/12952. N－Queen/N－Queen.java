import java.util.*;
class Solution {
    private static int[] map;
    private static int answer;
    public int solution(int n) {
        map=new int[n];
        queen(0,n);
        return answer;
    }
    static void queen(int cnt,int n){
        if(cnt==n){
            answer++;
            return;
        }
        for(int i=0; i<n; i++){
            map[cnt]=i;
            if(check(cnt)){
                queen(cnt+1,n);
            }
        }
    }
    static boolean check(int cnt){
        for(int i=0; i<cnt; i++){
            if(map[i]==map[cnt]){
                return false;
            }
            if(Math.abs(cnt-i)==Math.abs(map[cnt]-map[i])){
                return false;
            }
        }
        return true;
    }
}